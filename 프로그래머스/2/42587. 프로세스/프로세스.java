import java.util.*;

class Solution {
    
    public class P implements Comparable<P> {
        int p, order;
        
        public P(int p, int order) {
            this.p = p;
            this.order = order;
        }
        
        @Override
        public int compareTo(P o) {
            return o.order - this.order;
        }
    }
    
    public int solution(int[] priorities, int location) {
        
        Queue<P> q = new ArrayDeque<>();
        Queue<P> pq = new PriorityQueue<>();
        
        for (int i = 0; i < priorities.length; i++) {
            P p = new P(i, priorities[i]);
            q.add(p);
            pq.add(p);
        }
        
        int cnt = 1;
        
        while (!pq.isEmpty()) {
            P p = q.poll();
            if (pq.peek().order == p.order) {
                pq.poll();
                if (p.p == location) {
                    return cnt;
                }
                cnt++;
            } else {
                q.add(p);
            }
        }
        
        return -1;
    }
}