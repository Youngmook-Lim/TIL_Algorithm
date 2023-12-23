import java.util.*;

class Solution {
    
    Map<Character, Integer> map;
    
    public int[] solution(String s) {
        
        map = new HashMap<>();
        int[] answer = new int[s.length()];
                
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
               answer[i] = i - map.get(cur);
            } else {
               answer[i] = -1; 
            }
            map.put(cur, i);
        }
        
        return answer;
    }
}