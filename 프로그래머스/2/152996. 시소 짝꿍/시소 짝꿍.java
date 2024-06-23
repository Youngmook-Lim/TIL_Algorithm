import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        long[] arr = new long[1001];
        for (int x : weights) {
            arr[x]++;
        }
        
        for (int i = 100; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            answer += arr[i] * (arr[i] - 1) / 2;
            if ((i * 3) % 2 == 0 && (i * 3) / 2 < arr.length) {
                answer += arr[i] * arr[i * 3 / 2];
            }
            if (i * 2 < arr.length) {
                answer += arr[i] * arr[i * 2];
            }
            if ((i * 4) % 3 == 0 && (i * 4) / 3 < arr.length) {
                answer += arr[i] * arr[i * 4 / 3];
            }
        }
        
        return answer;
    }
}