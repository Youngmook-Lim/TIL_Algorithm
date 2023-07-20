import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                dp[i] = arr[i];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + arr[i];
            } else if (i == 3) {
                dp[i] = Math.max(dp[i - 2], arr[i - 1]) + arr[i];
            } else {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
            }
        }

        System.out.println(dp[n]);

        br.close();
    }


}

