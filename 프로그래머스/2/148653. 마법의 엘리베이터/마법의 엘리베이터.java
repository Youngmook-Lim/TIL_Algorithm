import java.util.*;

class Solution {
    
    class P {
        int cnt, storey, c;
        
        P(int cnt, int storey, int c) {
            this.cnt = cnt;
            this.storey = storey;
            this.c = c;
        }
    }
    
    boolean[] visited;
    
    public int solution(int storey) {
        
        visited = new boolean[500000001];
        
        Queue<P> q = new ArrayDeque<>();
        q.add(new P(0, storey, 0));
        
        while (!q.isEmpty()) {
            P p = q.poll();
            
            visited[p.storey] = true;
            
            if (p.storey == 0) {
                return p.cnt;
            }
            
            while (true) {
                int n = (int) Math.pow(10, p.c);
                int tmp = (p.storey / n) % 10;
            
                if (tmp == 0) {
                    p.c++;
                } else {
                    break;
                }
            }
            
            int n = (int) Math.pow(10, p.c);
            
            if (!visited[p.storey + n]) {
                q.add(new P(p.cnt + 1, p.storey + n, p.c));        
            }
            if (!visited[p.storey - n]) {
                q.add(new P(p.cnt + 1, p.storey - n, p.c));
            }
            
        }
        
        return -1;
    }
}