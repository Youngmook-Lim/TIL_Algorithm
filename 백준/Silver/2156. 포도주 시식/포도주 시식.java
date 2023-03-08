import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + arr[i];
            } else if (i == 2) {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], arr[i - 1] + arr[i]));
            } else {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
            }
        }

        System.out.println(dp[n - 1]);

        br.close();
    }


}


