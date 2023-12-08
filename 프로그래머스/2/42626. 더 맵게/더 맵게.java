import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        Queue<Long> pq = new PriorityQueue<>();
        for (int x : scoville) {
            pq.add((long) x);
        }
        
        int cnt = 0;
        
        while (!pq.isEmpty()) {
            long first = pq.poll();
            if (first >= K) return cnt;
            if (pq.isEmpty()) return -1;
            
            long second = pq.poll();
            long newSco = first + second * 2;
            pq.add(newSco);
            
            cnt++;
        }
        
        return -1;
    }
}