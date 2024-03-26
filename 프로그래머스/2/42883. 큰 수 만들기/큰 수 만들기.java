import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder(number);
        int idx = 0;
        for (int i = 0; i < k; i++) {
            for (int j = idx; j < sb.length() - 1; j++) {
                int a = sb.charAt(j);
                int b = sb.charAt(j + 1);
                if (b > a) {
                    sb.deleteCharAt(j);
                    idx = Math.max(j - 1, 0);
                    break;
                }
                if (j == sb.length() - 2) {
                    sb.deleteCharAt(j + 1);
                    idx = Math.max(j - 1, 0);
                }
            }
        }
        return sb.toString();
    }
}