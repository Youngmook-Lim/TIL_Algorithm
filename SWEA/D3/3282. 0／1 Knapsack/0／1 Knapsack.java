import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class Item {
        int volume, carat;

        public Item(int volume, int carat) {
            this.volume = volume;
            this.carat = carat;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            Item[] arr = new Item[n + 1];
            int[][] dp = new int[n + 1][k + 1];
            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = new Item(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < k + 1; j++) {
                    Item cur = arr[i];
                    if (cur.volume <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cur.volume] + cur.carat);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            sb.append("#" + t + " " + dp[n][k]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }


}