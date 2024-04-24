import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String x : gems) {
            set.add(x);
        }
        
        int n = gems.length;
        int m = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        int start = n;
        int end = n;
        int a = 0;
        int b = 0;
        int min = Integer.MAX_VALUE;
        
        while (start >= 0) {    
            // System.out.println(map);
            // System.out.println(start + "-" + end);
            if (map.keySet().size() == m) {
                end--;
                int diff = end - start;
                if (diff <= min) {
                    min = diff;
                    a = start;
                    b = end;                   
                }
                // System.out.println(a + " " + b);

                String cur = gems[end];
                if (map.get(cur) == 1) {
                    map.remove(cur);
                } else {
                    map.put(cur, map.get(cur) - 1);
                }
            } else {
                start--;
                if (start < 0) break;
                String cur = gems[start];
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }
        
        int[] answer = new int[2];
        answer[0] = a + 1;
        answer[1] = b + 1;
        
        return answer;
    }
}