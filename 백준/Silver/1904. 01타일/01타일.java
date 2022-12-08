import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static final int MOD = 15746;
    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
        }
        if (n > 2) {
            for (int i = 3; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }
        }

        System.out.println(dp[n]);

        br.close();
    }


}
