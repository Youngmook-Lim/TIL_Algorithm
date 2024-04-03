import java.util.*;

class Solution {
    
    public int solution(int sticker[]) {
        
        int n = sticker.length;
        int[] dp = new int[n];
        int answer = 0;
        
        if (n <= 3) {
            int max = 0;
            for (int x : sticker) {
                max = Math.max(max, x);
            }
            return max;
        }
        
        dp[0] = sticker[0];
        
        for (int i = 2; i < n - 1; i++) {
            dp[i] = sticker[i] + Math.max(dp[(n + i - 3) % n], dp[(n + i - 2) % n]); 
            answer = Math.max(answer, dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        dp = new int[n];
        dp[1] = sticker[1];
        
        for (int i = 2; i < n; i++) {
            dp[i] = sticker[i] + Math.max(dp[(n + i - 3) % n], dp[(n + i - 2) % n]); 
            answer = Math.max(answer, dp[i]);
        }
        
        // System.out.println(Arrays.toString(dp));

        return answer;
    }
}