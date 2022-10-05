import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            try {
                int n = Integer.parseInt(br.readLine());
                BigInteger[] dp = new BigInteger[n + 1];
                for (int i = 0; i < n + 1; i++) {
                    if (i < 2) {
                        dp[i] = BigInteger.valueOf(1);
                    } else if (i == 2) {
                        dp[i] = BigInteger.valueOf(3);
                    } else {
                        dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
                    }
                }
                sb.append(dp[n]).append('\n');

            } catch (Exception e) {
                break;
            }
        }
        System.out.println(sb);

        br.close();
    }


}

