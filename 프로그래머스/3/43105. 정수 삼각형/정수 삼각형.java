import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int len = triangle.length;
        
        int[][] dp = new int[len][];
        dp[0] = new int[1];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < len; i++) {
            dp[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }    
        }
        
        int answer = 0;
        
        for (int i = 0; i < len; i++) {
            answer = Math.max(dp[len - 1][i], answer);
        }
        
        return answer;
    }
}