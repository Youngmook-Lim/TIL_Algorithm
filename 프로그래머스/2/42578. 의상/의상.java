import java.util.*;

class Solution {
    
    Map<String, Integer> map;
    
    public int solution(String[][] clothes) {
        
        map = new HashMap<>();
        
        for (String[] arr : clothes) {
            String type = arr[1];            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for (int x : map.values()) {
            answer *= (x + 1);
        }
        
        answer--;        

        return answer;
    }
}