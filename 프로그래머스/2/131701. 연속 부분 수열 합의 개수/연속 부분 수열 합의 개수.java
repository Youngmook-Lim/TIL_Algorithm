import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        
        int[] cum = new int[len * 2 + 1];
        
        for (int i = 1; i < len * 2 + 1; i++) {
            cum[i] = cum[i - 1] + elements[(i - 1) % len];
        }
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = cum[i + j] - cum[j];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}