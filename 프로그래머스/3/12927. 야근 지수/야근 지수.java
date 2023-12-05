import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (int x : works) {
            pq.add(-x);
        }
        
        for (int i = 0; i < n; i++) {
            int tmp = pq.poll();
            if (tmp != 0) {
                pq.add(tmp + 1);    
            }
            if (pq.isEmpty()) break;
        }
        
        long answer = 0;
        
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}