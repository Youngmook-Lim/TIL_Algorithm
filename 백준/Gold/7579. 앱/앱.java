import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static final int INF = 987654321;
    static int n, m;
    static int[] bytes, cost;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bytes = new int[n + 1];
        cost = new int[n + 1];
        dp = new int[2][m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            bytes[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (bytes[i] < j) {
                    dp[1][j] = Math.min(dp[0][j], dp[0][j - bytes[i]] + cost[i]);
                } else {
                    dp[1][j] = Math.min(cost[i], dp[0][j]);
                }
            }
            for (int j = 1; j < m + 1; j++) {
                dp[0][j] = dp[1][j];
            }
        }

        System.out.println(dp[1][m]);

        br.close();

    }


}