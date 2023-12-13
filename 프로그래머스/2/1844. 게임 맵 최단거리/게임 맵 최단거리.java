import java.util.*;

class Solution {
    
    class P {
        int x, y, cnt;
        
        P(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    

    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<P> q = new ArrayDeque<>();
    
        q.add(new P(0, 0, 1));
        maps[0][0] = 0;

        while (!q.isEmpty()) {
            P p = q.poll();
            if (p.x == m - 1 && p.y == n - 1) {
                return p.cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (maps[ny][nx] == 0) continue;
                
                maps[ny][nx] = 0;
                q.add(new P(nx, ny, p.cnt + 1));
            }
            
        }
        
        return -1;

    }
}