import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        //
        StringBuilder sb = new StringBuilder();
        
        int num = 0;
        int idx = 1;
        
        loop:
        while (true) {
            String convertedNum = convert(num, n);
            for (int i = 0; i < convertedNum.length(); i++) {
                int curIdx = idx++ % m;
                if (curIdx == 0) {
                    curIdx = m;
                }
                if (curIdx == p) {
                    sb.append(convertedNum.charAt(i));
                    t--;
                }
                if (t == 0) {
                    break loop;
                }
            }
            num++;
        }
        
        return sb.toString();
    }
    
    public String convert(int num, int power) {
        return Integer.toString(num, power).toUpperCase();
    }
}