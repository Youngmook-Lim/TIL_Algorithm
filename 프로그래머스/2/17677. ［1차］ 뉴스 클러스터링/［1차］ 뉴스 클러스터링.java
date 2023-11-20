import java.util.*;

class Solution {
    
    public final int MULTIPLIER = 65536;
    Map<String, Integer> map1;
    Map<String, Integer> map2;
    Map<String, Integer> totalMap; 
    int size1;
    int size2;
    double intersection;
    double union;
    
    public int solution(String str1, String str2) {
        
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        totalMap = new HashMap<>();
        size1 = 0;
        size2 = 0;
        union = 0;
        
        fillMap(str1, map1, size1);
        fillMap(str2, map2, size2);
        
        intersection = size1 < size2 ? getIntersection(map1, map2) : getIntersection(map2, map1);
        
        fillTotalMap(map1);
        fillTotalMap(map2);
                
        for (Integer x : totalMap.values()) {
            union += x;
        }
        
        double answer = union == 0 ? 1 : intersection / union;
        
        return (int) (answer * MULTIPLIER);
    }
    
    public void fillTotalMap(Map<String, Integer> map) {
        for (String x : map.keySet()) {
            if (totalMap.containsKey(x)) {
                totalMap.put(x, Math.max(totalMap.get(x), map.get(x)));
            } else {
                totalMap.put(x, map.get(x));                
            }
        }
    }
    
    public void fillMap(String str, Map<String, Integer> map, int size) {
        for (int i = 0; i < str.length() - 1; i++) {
            String tmp = str.substring(i, i + 2).toLowerCase();
            if (tmp.charAt(0) < 'a' || tmp.charAt(0) > 'z' || tmp.charAt(1) < 'a' || tmp.charAt(1) > 'z') continue;
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            size++;
        }
    }
    
    public double getIntersection(Map<String, Integer> m1, Map<String, Integer> m2) {
        double result = 0;
        for (String key : m1.keySet()) {
            if (m2.get(key) == null) continue;
            result += Math.min(m1.get(key), m2.get(key));
        }
        return result;
    }
}