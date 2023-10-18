import java.util.*;

class Solution {
    public int solution(int n) {
        
        String bin = Integer.toBinaryString(n);
        
        int idx = 0;
        
        for (int i = bin.length() - 1; i > 0; i--) {
            if (bin.charAt(i) == '1' && bin.charAt(i - 1) == '0') {
                idx = i;
                break;
            }
        }
        
        int cnt = 0;
        
        for (int i = idx + 1; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') cnt++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < idx - 1; i++) {
            sb.append(bin.charAt(i));
        }
        
        sb.append(1).append(0);
        
        for (int i = 0; i < bin.length() - idx - 1; i++) {
            if (i < bin.length() - idx - 1 - cnt) {
                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        
        int answer = Integer.parseInt(sb.toString(), 2);
        return answer;
    }
}