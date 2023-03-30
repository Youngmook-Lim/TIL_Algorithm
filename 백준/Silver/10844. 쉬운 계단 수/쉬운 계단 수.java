import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int MOD = 1_000_000_000;

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[101][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1L;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % MOD;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        long total = 0;
        for (int i = 0; i < 10; i++) {
            total += dp[n][i];
        }

        System.out.println(total % MOD);

        br.close();
    }


}

