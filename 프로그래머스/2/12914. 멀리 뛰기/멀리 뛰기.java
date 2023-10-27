class Solution {
    
    int[] dp;
    final int MOD = 1234567;
    
    public long solution(int n) {
        
        if (n < 3) {
            return n;
        }
        
        dp = new int[n + 1];
        
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        
        return dp[n];
    }
}
