import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        result = new int[n + 1];
        adj = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < n + 1; i++) {
            sb.append(result[i]).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int x : adj[node]) {
            if (!visited[x]) {
                result[x] = node;
                dfs(x);
            }
        }
    }


}

