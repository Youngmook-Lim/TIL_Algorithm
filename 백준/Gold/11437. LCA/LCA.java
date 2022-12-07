import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n, m;
    static int[] depth, childParent;
    static List<Integer>[] adj;
    static boolean[] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        depth = new int[n + 1];
        childParent = new int[n + 1];
        childParent[1] = 1;

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
        depth[cur] = curDepth;

        for (int next : adj[cur]) {
            if (!visited[next]) {
                childParent[next] = cur;
                markDepth(next, curDepth + 1);
            }
        }
    }

    static int lca(int a, int b) {
        int depthA = depth[a];
        int depthB = depth[b];
        int parentA = childParent[a];
        int parentB = childParent[b];

        if (depthA > depthB) {
            while (depthA != depthB) {
                a = parentA;
                parentA = childParent[a];
                depthA--;
            }
        } else if (depthA < depthB) {
            while (depthB != depthA) {
                b = parentB;
                parentB = childParent[b];
                depthB--;
            }
        }

        if (a == b) return a;
        if (a == 1 || b == 1) return 1;

        return lca(parentA, parentB);

    }

}
