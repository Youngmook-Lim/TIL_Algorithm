import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


public class Main {

    static BigInteger[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        dp = new BigInteger[n + 1];

        if (n >= 0) {
            dp[0] = BigInteger.ZERO;
        }
        if (n >= 1) {
            dp[1] = BigInteger.ONE;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2].add(dp[i - 1]);
        }

        System.out.println(dp[n]);

        br.close();
    }

}
