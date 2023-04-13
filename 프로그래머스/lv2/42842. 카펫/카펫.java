import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int target = (brown + 4) / 2;
        for (int i = 3; i < target - 2; i++) {
            // System.out.println(i + " " + (target - i));
            int j = target - i;
            if ((i - 2) * (j - 2) == yellow) {
                if (i > j) {
                    answer[0] = i;
                    answer[1] = j;    
                } else {
                    answer[1] = i;
                    answer[0] = j;
                }
                
            }
        }
        
        return answer;
    }
}