import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dp[1][0] = Math.min(dp[0][1], dp[0][2]) + Integer.parseInt(st.nextToken());
            dp[1][1] = Math.min(dp[0][0], dp[0][2]) + Integer.parseInt(st.nextToken());
            dp[1][2] = Math.min(dp[0][0], dp[0][1]) + Integer.parseInt(st.nextToken());

            dp[0][0] = dp[1][0];
            dp[0][1] = dp[1][1];
            dp[0][2] = dp[1][2];
        }

        System.out.println(Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]));

        br.close();
    }


}

