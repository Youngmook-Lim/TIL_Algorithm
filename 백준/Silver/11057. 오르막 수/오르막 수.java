import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static int[][] dp;
    static final int MOD = 10007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][10];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                int cnt = 0;
                for (int k = 0; k <= j; k++) {
                    cnt = (cnt + dp[i - 1][k]) % MOD;
                }
                dp[i][j] = cnt;
            }
        }

        int sol = 0;
        for (int i = 0; i < 10; i++) {
            sol = (sol + dp[n][i]) % MOD;
        }

        System.out.println(sol);

        br.close();
    }


}
