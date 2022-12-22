import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = 987654321;
    static int n, ans;
    static int[][] adj, memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        adj = new int[n][n];
        memo = new int[n][(1 << n)];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = INF;
        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }

        for (int i = 1; i < n; i++) {
            int dist = getShortestDistance(i, (1 << n) - 1);
            if (adj[i][0] != 0) {
                ans = Math.min(ans, dist + adj[i][0]);
            }
        }

        System.out.println(ans);

        br.close();
    }

    static int getShortestDistance(int destination, int visited) {
        if (visited == ((1 << destination) | 1)) {
            if (adj[0][destination] == 0) {
                return INF;
            }
            return adj[0][destination];
        }
        if (memo[destination][visited] != -1) {
            return memo[destination][visited];
        }

        int result = INF;

        for (int i = 1; i < n; i++) {
            if (i != destination && (visited & (1 << i)) != 0 && adj[i][destination] != 0) {
                int shortestDistance = getShortestDistance(i, visited & (~(1 << destination)));
                result = Math.min(result,
                        shortestDistance + adj[i][destination]);
            }
        }

        return memo[destination][visited] = result;
    }


}
