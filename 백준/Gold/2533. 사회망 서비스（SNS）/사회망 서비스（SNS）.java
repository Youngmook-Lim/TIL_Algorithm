import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] adj;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        adj = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        dp = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        getEarlyAdaptors(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));

        br.close();
    }

    static void getEarlyAdaptors(int cur) {
        
        visited[cur] = true;
        dp[cur][0] = 0;
        dp[cur][1] = 1;

        for (int x : adj[cur]) {
            if (visited[x]) continue;
            getEarlyAdaptors(x);
            dp[cur][0] += dp[x][1];
            dp[cur][1] += Math.min(dp[x][0], dp[x][1]);
        }

    }
}
