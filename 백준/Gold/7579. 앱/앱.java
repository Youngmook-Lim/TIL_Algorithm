import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, m, totalCost;
    static int[] bytes, cost;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bytes = new int[n + 1];
        cost = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            bytes[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            totalCost += cost[i];
        }

        dp = new int[n + 1][totalCost + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < totalCost + 1; j++) {
                if (cost[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], bytes[i] + dp[i - 1][j - cost[i]]);
                }
            }
        }

        for (int i = 1; i < totalCost + 1; i++) {
            if (dp[n][i] >= m) {
                System.out.println(i);
                break;
            }
        }


        br.close();

    }


}