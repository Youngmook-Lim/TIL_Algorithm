import java.util.*;

class Solution {
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (int i = 0; i < babbling.length; i++) {
            String cur = babbling[i];
            int idx = 0;
            String prev = null;
            // boolean flag = true;
            
            while (idx < cur.length() - 1) {
                String word = cur.substring(idx, idx + 2);
                
                if (word.equals("ye") || word.equals("ma")) {
                    if (prev != null && prev.equals(word)) {
                        // flag = false;
                        break;
                    }
                    idx += 2;
                    prev = word;
                    continue;
                }
                
                if (idx + 2 >= cur.length()) break;
                
                word += cur.charAt(idx + 2);
                
                if (word.equals("aya") || word.equals("woo")) {
                    if (prev != null && prev.equals(word)) {
                        // flag = false;
                        break;
                    }
                    idx += 3;
                    prev = word;
                    continue;
                }
                
                // flag = false;
                break;
            }
            
            if (idx == cur.length()) {
                answer++;
            }
        }
        
        return answer;
    }
}