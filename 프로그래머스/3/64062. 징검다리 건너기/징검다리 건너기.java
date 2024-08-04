import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int mid = 0;
        int left = 1;
        int right = Arrays.stream(stones).max().getAsInt();
        while (left <= right) {
            mid = (left + right) / 2;
            int n = check(stones, mid);
            if (n >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public int check(int[] stones, int mid) {
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < stones.length; i++) {
            int cur = stones[i] - mid;
            if (cur <= 0) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                cnt = 0;
            }
        }
        System.out.println(max);
        return max;
    }
}