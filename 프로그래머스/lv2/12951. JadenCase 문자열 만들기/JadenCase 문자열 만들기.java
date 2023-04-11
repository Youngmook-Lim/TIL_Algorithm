import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        boolean flag = false;
        
        for (int i = 0; i < s.length(); i++) {
            String str = Character.toString(s.charAt(i));
            if (!str.equals(" ")) {
                if (!flag) {
                    str = str.toUpperCase();
                    flag = true;
                } else {
                    str = str.toLowerCase();
                }
            } else if (str.equals(" ") && flag) {
                flag = false;
            } 
            answer += str;
        }
        
        return answer;
    }
}