import java.util.*;

class Solution {
    public int solution(int n) {
        
        int start = 0;
        int end = 1;
        int answer = 0;
        
        int[] arr = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + i;
        }
        
        while (end <= n || start == end) {
            int sum = arr[end] - arr[start];
            
            if (sum == n) {
                answer++;
                start++;
            } else if (sum > n) {
                start++;
            } else {
                end++;
            }
        }
        
        return answer;
    }
}