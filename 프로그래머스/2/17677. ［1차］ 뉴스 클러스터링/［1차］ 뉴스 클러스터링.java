import java.util.*;

class Solution {
    
    public final int MULTIPLIER = 65536;
    Map<String, Integer> map1;
    Map<String, Integer> map2;
    Map<String, Integer> totalMap; 
    
    public int solution(String str1, String str2) {
        
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        int size1 = 0;
        int size2 = 0;
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = str1.substring(i, i + 2).toLowerCase();
            if (tmp.charAt(0) < 'a' || tmp.charAt(0) > 'z' || tmp.charAt(1) < 'a' || tmp.charAt(1) > 'z') continue;
            map1.put(tmp, map1.getOrDefault(tmp, 0) + 1);
            size1++;
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp = str2.substring(i, i + 2).toLowerCase();
            if (tmp.charAt(0) < 'a' || tmp.charAt(0) > 'z' || tmp.charAt(1) < 'a' || tmp.charAt(1) > 'z') continue;
            map2.put(tmp, map2.getOrDefault(tmp, 0) + 1);
            size2++;
        }
        
        double intersection = size1 < size2 ? getIntersection(map1, map2) : getIntersection(map2, map1);
        
        totalMap = new HashMap<>();
        
        for (String x : map1.keySet()) {
            if (totalMap.containsKey(x)) {
                totalMap.put(x, Math.max(totalMap.get(x), map1.get(x)));
            } else {
                totalMap.put(x, map1.get(x));                
            }
        }
        
        for (String x : map2.keySet()) {
            if (totalMap.containsKey(x)) {
                totalMap.put(x, Math.max(totalMap.get(x), map2.get(x)));
            } else {
                totalMap.put(x, map2.get(x));                
            }
        }
        
        double union = 0;
        for (Integer x : totalMap.values()) {
            union += x;
        }
        
        if (union == 0) {
            return MULTIPLIER;
        } else {
            return (int) ((intersection / union) * MULTIPLIER);
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