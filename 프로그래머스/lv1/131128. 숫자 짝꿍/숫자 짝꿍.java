import java.util.*;

class Solution {
    
    int[] xCnts, yCnts;
    List<Integer> list;
    boolean isZero;
    
    public String solution(String X, String Y) {
        
        xCnts = new int[10];
        yCnts = new int[10];
        list = new ArrayList<>();
        isZero = true;
        
        for (int i = 0; i < X.length(); i++) {
            int digit = X.charAt(i) - '0';
            xCnts[digit]++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            int digit = Y.charAt(i) - '0';
            yCnts[digit]++;
        }
        
        for (int i = 0; i < 10; i++) {
            int n = Math.min(xCnts[i], yCnts[i]);
            for (int j = 0 ; j < n; j++) {
                if (i != 0) {
                    isZero = false;                
                }
                list.add(i);
            }
        }
        
        if (list.isEmpty()) {
            return "-1";
        }
        
        if (isZero) {
            return "0";
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        
        for (int x : list) {
            sb.append(x);
        }
        
        return sb.toString();
    }
}