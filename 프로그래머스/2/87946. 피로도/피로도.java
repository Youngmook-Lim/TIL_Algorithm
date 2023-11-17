import java.util.*;

class Solution {
    
    boolean[] visited;
    List<Integer> list;
    int answer;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        list = new ArrayList<>();
        
        dfs(0, dungeons, k);
        
        return answer;
    }
    
    public void dfs(int depth, int[][] dungeons, int k) {
        System.out.println(k);
        
        answer = Math.max(answer, depth);
        
        if (depth == dungeons.length) {
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                if (dungeons[i][0] > k) continue;
                k -= dungeons[i][1];
                // list.add(i);
                visited[i] = true;               
                dfs(depth + 1, dungeons, k);
                visited[i] = false;
                // list.remove(list.size() - 1);
                k += dungeons[i][1];
            }
        }
        
    }
}