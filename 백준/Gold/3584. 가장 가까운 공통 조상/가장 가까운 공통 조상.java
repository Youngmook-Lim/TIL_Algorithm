import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, n, A, B;
    static List<Integer>[] adj, adjRev;
    static int[] parent, child, depths;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            adj = new List[n + 1];
            adjRev = new List[n + 1];
            parent = new int[n + 1];
            child = new int[n + 1];
            depths = new int[n + 1];

            for (int i = 1; i < n + 1; i++) {
                adj[i] = new ArrayList<>();
                adjRev[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                parent[a]++;
                child[b]++;
                adjRev[b].add(a);
                adj[a].add(b);
            }

            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            int start = findRoot();
            markDepth(start, 0);
            sb.append(findNearestCommonAncestor(A, B)).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    static int findNearestCommonAncestor(int a, int b) {
        int depthA = depths[a];
        int depthB = depths[b];
        while (depthA != depthB) {
            if (depthA > depthB) {
                a = adjRev[a].get(0);
                depthA--;
            } else {
                b = adjRev[b].get(0);
                depthB--;
            }
        }
        while (a != b) {
            a = adjRev[a].get(0);
            b = adjRev[b].get(0);
        }
        return a;
    }

    static void markDepth(int node, int depth) {
        depths[node] = depth;
        for (int x : adj[node]) {
            markDepth(x, depth + 1);
        }
    }

    static int findRoot() {
        for (int i = 1; i < n + 1; i++) {
            if (parent[i] > 0 && child[i] == 0) {
                return i;
            }
        }
        return -1;
    }

}
