import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 2][M + 2];
        dp = new int[N + 2][M + 2];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = getAns(N, M);

        System.out.println(ans);

        br.close();
    }

    static int getAns(int n, int m) {
        if (n == 1 && m == 1) {
            return 1;
        }
        if (n < 1 || m < 1 || n > N || m > M) {
            return 0;
        }

        if (dp[n][m] == -1) {
            int up = 0;
            int left = 0;
            int right = 0;
            int down = 0;
            if (graph[n][m] < graph[n - 1][m]) {
                up = getAns(n - 1, m);
            }
            if (graph[n][m] < graph[n][m - 1]) {
                left = getAns(n, m - 1);
            }
            if (graph[n][m] < graph[n][m + 1]) {
                right = getAns(n, m + 1);
            }
            if (graph[n][m] < graph[n + 1][m]) {
                down = getAns(n + 1, m);
            }
            dp[n][m] = up + left + right + down;
        }
        return dp[n][m];
    }

}
