import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int cnt = 0;
        int total = 0;
        
        while (!s.equals("1")) {
            int zeros = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeros++;
                }
            }
            
            cnt++;
            total += zeros;
            
            int tmp = s.length() - zeros;
            
            s = Integer.toBinaryString(tmp);
        }

        int[] answer = {cnt, total};
        
        return answer;
    }
}