import java.util.*;

class Solution {
    
    class P {
        int pos, cnt;
        P (int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
    
    public int solution(int x, int y, int n) {
        
        Queue<P> q = new ArrayDeque<>();
        boolean[] visited = new boolean[y + 1];
        
        q.add(new P(x, 0));
        visited[x] = true;
        
        while (!q.isEmpty()) {
            P p = q.poll();
            
            if (p.pos == y) return p.cnt;
            
            int next1 = p.pos + n;
            int next2 = p.pos * 2;
            int next3 = p.pos * 3;
            
            if (next1 <= y && !visited[next1]) {
                q.add(new P(next1, p.cnt + 1));
                visited[next1] = true;
            }
            if (next2 <= y && !visited[next2]) {
                q.add(new P(next2, p.cnt + 1));
                visited[next2] = true;
            }
            if (next3 <= y && !visited[next3]) {
                q.add(new P(next3, p.cnt + 1));
                visited[next3] = true;
            }
            
        }
        
        return -1;
    }
}