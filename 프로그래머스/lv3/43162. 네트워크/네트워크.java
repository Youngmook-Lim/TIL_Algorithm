import java.util.*;

class Solution {
    int[][] computers;
    boolean[] visited;
    
    int n;
    int cnt;
    
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.n = n;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);   
                cnt++;
            }
        }
            
        return cnt;
    }
    
    void dfs(int node) {
        visited[node] = true;
        
        for (int i = 0; i < n; i++) {
            if (node == i) continue;
            if (visited[i]) continue;
            if (computers[node][i] == 0) continue;
            
            dfs(i);
        }
    }
}