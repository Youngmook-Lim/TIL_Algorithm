import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int n, w, numOfLeafNodes;
    static boolean[] visited;
    static List<Integer>[] adj;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        adj = new List[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(1);

        System.out.println((double) w / numOfLeafNodes);

        br.close();
    }

    static void dfs(int cur) {
        visited[cur] = true;

        boolean flag = false;
        for (int x : adj[cur]) {
            if (!visited[x]) {
                flag = true;
                dfs(x);
            }
        }
        if (!flag) {
            numOfLeafNodes++;
        }
    }


}

