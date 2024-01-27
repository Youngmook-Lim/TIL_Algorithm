import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int cnt = 1;
        
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if (x == cur) {
                cnt++;
            } else {
                cnt--;
            }
            
            if (cnt == 0) {
                answer++;
                if (i != s.length() - 1) {
                    x = s.charAt(i + 1);
                    cnt = 1;
                    i++;
                } else {
                    answer--;
                }
            }
            
        }
        
        return answer + 1;
    }
}