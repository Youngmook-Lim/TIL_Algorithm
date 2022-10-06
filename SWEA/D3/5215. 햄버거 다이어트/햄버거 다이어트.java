import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, l;
    static int[][] dp;
    static Ingredient[] hamburgers;

    static class Ingredient {
        int score, cal;

        public Ingredient(int score, int cal) {
            this.score = score;
            this.cal = cal;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            dp = new int[n + 1][l + 1];
            hamburgers = new Ingredient[n + 1];
            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());
                hamburgers[i] = new Ingredient(score, cal);
            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < l + 1; j++) {
                    Ingredient cur = hamburgers[i];
                    if (cur.cal <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cur.cal] + cur.score);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            sb.append("#" + t + " " + dp[n][l]).append('\n');

        }
        System.out.println(sb);
        br.close();
    }


}