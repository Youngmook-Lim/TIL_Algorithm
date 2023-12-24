import java.util.*;

class Solution {
    
    class P {
        String word;
        int cnt;
        
        P(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    boolean[] visited;
    boolean flag;
    Queue<P> q;
    
    public int solution(String begin, String target, String[] words) {
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                flag = true;
            }
        }
        
        if (!flag) return 0;
        
        visited = new boolean[words.length];
        q = new ArrayDeque<>();
        q.add(new P(begin, 0));
        
        while (!q.isEmpty()) {
            P p = q.poll();
            
            if (p.word.equals(target)) {
                return p.cnt;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canGo(p.word, words[i])) {
                    visited[i] = true;
                    q.add(new P(words[i], p.cnt + 1));
                }
            }
        }
        
        return 0;
    }
    
    boolean canGo(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}