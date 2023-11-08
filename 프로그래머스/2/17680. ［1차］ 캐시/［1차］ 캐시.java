import java.util.*;

class Solution {
    
    Queue<String> queue;
    Set<String> set;
    
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
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
                if (set.size() >= cacheSize) {
                    String d = queue.poll();
                    set.remove(d);
                } 
                queue.add(x);
                set.add(x);
                
                answer += 5;
            }
        }
                
        return answer;
    }
}