import java.util.*;

class Solution {
    
    public int solution(int[] ingredient) {
        int answer = 0;
        
        int[] stack = new int[ingredient.length];
        int idx = 0;
        
        for (int i = 0; i < ingredient.length; i++) {
            stack[idx] = ingredient[i];
            if (idx < 3) {
                idx++;
                continue;
            }
            
            int a = stack[idx - 3];
            int b = stack[idx - 2];
            int c = stack[idx - 1];
            int d = stack[idx];
            
            if (a == 1 && b == 2 && c == 3 && d == 1) {
                answer++;
                idx -= 4;
            }
            
            idx++;
            
        }
        
        return answer;
    }
}