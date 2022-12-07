import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n, m;
    static Map<Integer, Integer> depth;
    static Map<Integer, Integer> childParent;
    static List<Integer>[] adj;
    static boolean[] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        depth = new HashMap<>();
        childParent = new HashMap<>();
        childParent.put(1, 1);

        n = Integer.parseInt(br.readLine());
        adj = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        markDepth(1, 0);

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    static void markDepth(int cur, int curDepth) {
        visited[cur] = true;
        depth.put(cur, curDepth);

        for (int next : adj[cur]) {
            if (!visited[next]) {
                childParent.put(next, cur);
                markDepth(next, curDepth + 1);
            }
        }
    }

    static int lca(int a, int b) {
        if (a == b) return a;
        if (a == 1 || b == 1) return 1;

        int depthA = depth.get(a);
        int depthB = depth.get(b);
        int parentA = childParent.get(a);
        int parentB = childParent.get(b);
        if (depthA == depthB) {
            return lca(parentA, parentB);
        } else {
            if (depthA > depthB) {
                return lca(parentA, b);
            } else {
                return lca(a, parentB);
            }
        }
    }

}
