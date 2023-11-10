import java.util.*;

class Solution {
    
    public class P implements Comparable<P> {
        int n;
        int cnt;
        
        public P(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(P o) {
            return o.cnt - this.cnt;
        }
    }
    
    public int[] solution(String s) {
        
        HashMap<String, Integer> map = new HashMap<>();
        List<P> list = new ArrayList<>();
        
        String[] arr1 = s.split("},\\{");
        
        for (int i = 0; i < arr1.length; i++) {
            String tmp = arr1[i];
            String cur = tmp;
            
            if (i == 0) {
                cur = cur.substring(2, cur.length());
            } 
            
            if (i == arr1.length - 1) {
                cur = cur.substring(0, cur.length() - 2);
            } 
            
            String[] arr2 = cur.split("\\,");
            for (String x : arr2) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        
        for (String x : map.keySet()) {
            list.add(new P(Integer.parseInt(x), map.get(x)));
        }
        
        Collections.sort(list);
                
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).n;
        }

        return answer;
    }
}