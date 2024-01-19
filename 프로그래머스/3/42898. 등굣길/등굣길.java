import java.util.*;

class Solution {
    
    int[][] dp;
    boolean[][] graph;
    final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        
        graph = new boolean[n + 1][m + 1];
        for (int[] puddle : puddles) {
            graph[puddle[1]][puddle[0]] = true;
        }
        
        dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (graph[i][j]) continue;
                if (i == 1 && j == 1) continue;
                dp[i][j] = (dp[i - 1][j] % MOD + dp[i][j - 1] % MOD) % MOD;
            }
        }

        return dp[n][m];
    }
}