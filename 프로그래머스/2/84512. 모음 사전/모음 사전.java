import java.util.*;

class Solution {
    
    List<Character> list;
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    char[] words;
    int answer;
    boolean flag;
    
    public int solution(String word) {
        
        list = new ArrayList<>();
        words = word.toCharArray();
        answer = 0;

        dfs(0);
        
        return answer - 1;
    }
    
    public void dfs(int depth) {

        if (flag) return;
        if (depth == 6) return;
        
        answer++;
        
        check();
        
        for (int i = 0; i < 5; i++) {
            list.add(vowels[i]);
            dfs(depth + 1);
            list.remove(list.size() - 1);
        }
    }
    
    public void check() {
        if (list.size() != words.length) return;
        for (int i = 0; i < words.length; i++) {
            if (list.get(i) != words[i]) return;
        }
        flag = true;
        return;
    }
}