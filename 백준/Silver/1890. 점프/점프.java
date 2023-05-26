import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static int[][] graph;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int num = graph[i][j];
                if (num == 0) continue;
                int newPosX = j + num;
                if (newPosX >= 0 && newPosX < n) {
                    dp[i][j] += dp[i][newPosX];
                }
                int newPosY = i + num;
                if (newPosY >= 0 && newPosY < n) {
                    dp[i][j] += dp[newPosY][j];
                }
            }
        }

//        for (long[] x : dp) {
//            System.out.println(Arrays.toString(x));
//        }

        System.out.println(dp[0][0]);

        br.close();
    }


}
