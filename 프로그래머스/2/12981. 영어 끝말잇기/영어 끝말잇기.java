import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> set = new HashSet<>();
        int rotation = 1;
        int cur = 1;
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if (i > 0) {
                if (set.contains(word) || words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                    return new int[] {cur, rotation};
                }
            }
            
            set.add(word);
            cur++;
            if (cur > n) {
                cur = 1;
                rotation++;
            }
        }
        
        return new int[] {0, 0};
    }
}