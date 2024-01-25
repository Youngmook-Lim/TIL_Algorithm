import java.util.*;

class Solution {
    
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(String[][] board, int h, int w) {
        
        int H = board.length;
        int W = board[0].length;
        
        String curColor = board[h][w];

        int answer = 0;
        
        for (int i = 0; i < 4; i++) {
            int nh = h + dy[i];
            int nw = w + dx[i];
            
            if (nh < 0 || nh >= H || nw < 0 || nw >= W) continue;
            String adjColor = board[nh][nw];
            if (curColor.equals(adjColor)) answer++;    
        }
        
        return answer;
    }
}