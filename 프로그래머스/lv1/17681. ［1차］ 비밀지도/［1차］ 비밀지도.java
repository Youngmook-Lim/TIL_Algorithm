import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }
        
        System.out.println(Arrays.toString(answer));
        
        for (int i = 0; i < n; i++) {
            String tmp = "";
            for (int j = 0; j < n; j++) {
                String now = String.format("%" + n + "s", answer[i]);
                System.out.println(now);
                if (now.charAt(j) == '1') {
                    tmp += "#";
                } else {
                    tmp += " ";
                }
            }
            answer[i] = tmp;
        }
        
        return answer;
    }
}