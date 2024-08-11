import java.util.*;

class Solution {
    public String solution(String p) {       
        return fuckThis(p);
    }
    
    public String fuckThis(String s) {
        if (s.equals("")) return s;
        if (checkCorrect(s)) return s;
        
        int idx = findIdx(s);
        
        String u = s.substring(0, idx);
        String v = s.substring(idx);
        
        if (checkCorrect(u)) {
            return u + fuckThis(v);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < u.length() - 1; i++) {
                char c = u.charAt(i);
                sb.append(c == '(' ? ')' : '(');
            }
            return "(" + fuckThis(v) + ")" + sb.toString();
        }
        
    }
    
    public boolean checkCorrect(String s) {
        int cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0) return false;
        }
        
        return cnt == 0;
    }
    
    public int findIdx(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                return i + 1;
            }
        }
        return -1;
    }
    
    
}