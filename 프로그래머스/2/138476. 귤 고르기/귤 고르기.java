import java.util.*;

class Solution {
    
    public class P implements Comparable<P>{
        int num, cnt;
        
        public P(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(P o) {
            return o.cnt - this.cnt;
        }
        
    }
    
    public int solution(int k, int[] tangerine) {

        Map<Integer, Integer> map = new HashMap<>();
        
        for (int x : tangerine) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        Queue<P> pq = new PriorityQueue<>();
        
        for (int x : map.keySet()) {
            pq.add(new P(x, map.get(x)));
        }
        
        int answer = 0;
        
        while (k > 0) {
            P p = pq.poll();
            k -= p.cnt;
            answer++;
        }
        
        return answer;

    }
}