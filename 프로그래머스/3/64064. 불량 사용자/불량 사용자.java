import java.util.*;

class Solution {
    String[] userId;
    String[] bannedId;
    int idx, n, m, cnt;
    Set<String> set;
    List<String> list;
    boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        this.userId = user_id;
        this.bannedId = banned_id;
        this.n = banned_id.length;
        this.m = user_id.length;
        this.idx = 0;
        this.cnt = 0;
        this.set = new HashSet<>();  
        this.list = new ArrayList<>();
        this.visited = new boolean[m];
        
        dfs(0);
        
        return cnt;
    }
    
    public void dfs(int depth) {
        if (depth == n) {
            check();
            return;
        }
        
        for (int i = 0; i < m; i++) {
            if (visited[i]) continue;
            if (!match(userId[i])) continue;
            visited[i] = true;
            idx++;
            list.add(userId[i]);
            dfs(depth + 1);
            visited[i] = false;
            idx--;
            list.remove(list.size() - 1);
        }
    }
    
    public void check() {
        String[] tmp = new String[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = list.get(i);
        }
        Arrays.sort(tmp);
        StringBuilder sb = new StringBuilder();
        for (String x : tmp) {
            sb.append(x);
        }
        if (!set.contains(sb.toString())) {
            set.add(sb.toString());
            cnt++;
        }
    }
    
    public boolean match(String word) {
        String cur = bannedId[idx];
        if (word.length() != cur.length()) return false;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            char b = cur.charAt(i);
            if (b != '*' && a != b) return false;
        }
        return true;
    }
}