import java.util.*;

class Solution {
    
    Map<String, Integer> map;    
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
                
        int[] answer = new int[photo.length];
        
        for (int j = 0; j < photo.length; j++) {
            String[] s = photo[j];
            int sum = 0;
            for (int i = 0; i < s.length; i++) {
                if (map.containsKey(s[i])) {
                    sum += map.get(s[i]);
                }
            }
            answer[j] = sum;
        }
        
        return answer;
    }
}