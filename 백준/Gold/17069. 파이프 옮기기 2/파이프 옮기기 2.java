import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n + 1][n + 1];
        long[][][] dp = new long[n + 1][n + 1][3];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][2][0] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 3; j < n + 1; j++) {
                if (graph[i][j] != 1) {
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];
                    if (graph[i - 1][j] != 1 && graph[i][j - 1] != 1) {
                        dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                    }
                    dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];
                }
            }
        }

        long ans = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];

        System.out.println(ans);

        br.close();
    }


}
