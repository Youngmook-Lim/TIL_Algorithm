import java.util.*;

class Solution {
    
    Queue<String> queue;
    Set<String> set;
    
    public int solution(int cacheSize, String[] cities) {
        
        int answer = 0;
        queue = new LinkedList<>();
        set = new HashSet<>();
        
        for (String city : cities) {
            String x = city.toLowerCase();
                
            if (set.contains(x)) {
                queue.remove(x);
                queue.add(x);
                answer++;
            } else {
                if (cacheSize > 0) {
                    if (set.size() >= cacheSize) {
                        String d = queue.poll();
                        set.remove(d);
                    } 
                    queue.add(x);
                    set.add(x);
                }
                answer += 5;
            }
        }
                
        return answer;
    }
}