import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            int x = 1;
            while (x * x <= i) {
                dp[i] = Math.min(dp[i], dp[i - x * x] + 1);
                x++;
            }
        }

        System.out.println(dp[n]);

        br.close();
    }


}


