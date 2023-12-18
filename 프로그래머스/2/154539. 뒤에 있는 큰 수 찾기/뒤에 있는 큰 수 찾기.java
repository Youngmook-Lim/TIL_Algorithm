import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] dp = new int[numbers.length];
        dp[dp.length - 1] = -1;
        
        for (int i = numbers.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    dp[i] = numbers[j];
                    break;
                } else if (numbers[i] == numbers[j]) {
                    dp[i] = dp[j];
                    break;
                } else {
                    if (numbers[i] < dp[j]) {
                        dp[i] = dp[j];
                        break;
                    } else if (dp[j] == -1) {
                        dp[i] = -1;
                        break; 
                    }
                }
            }
        }
        
        return dp;
    }
}