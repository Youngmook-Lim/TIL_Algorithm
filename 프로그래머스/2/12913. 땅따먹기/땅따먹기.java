import java.util.*;

class Solution {
    int solution(int[][] land) {
        
        int[][] dp = new int[2][4];
        for (int i = 0; i < 4; i++) {
            dp[1][i] = land[0][i];
        }
        
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[0][j] = dp[1][j];
            }
            
            for (int j = 0; j < 4; j++) {
                dp[1][j] = land[i][j] + Math.max(Math.max(dp[0][(j + 1) % 4], dp[0][(j + 2) % 4]), dp[0][(j + 3) % 4]);
            }
        }
        
        int answer = 0;

        for (int x : dp[1]) {
            answer = Math.max(x, answer);
        }

        return answer;
    }
}