import java.util.*;


class Solution {
    public String solution(String s) {
        String[] sParsed = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < sParsed.length; i++) {
            int cur = Integer.parseInt(sParsed[i]);
            if (cur > max) {
                max = cur;
            }
            if (cur < min) {
                min = cur;
            }
        }
        
        String answer = min + " " + max;
        return answer;
    }
}