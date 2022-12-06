import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static final int INF = 987654321;
    static int n;
    static int[][] dp;
    static P[] input;

    static class P {
        int r, c;

        public P(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "{" +
                    r +
                    ", " + c +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        input = new P[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            input[i] = new P(r, c);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = INF;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i + j < n; i++) {
                calc(i, i + j);
            }
        }

        System.out.println(dp[0][n - 1]);

        br.close();
    }

    static void calc(int start, int end) {
        for (int i = start; i < end; i++) {
            int result = dp[start][i] + dp[i + 1][end] + input[start].r * input[i].c * input[end].c;
            dp[start][end] = Math.min(dp[start][end], result);
        }
    }

}
