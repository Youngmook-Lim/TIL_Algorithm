import java.util.*;

class Solution {
    
    char[][] graph;
    List<Integer> list;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int n, m;
        
    class P {
        int x, y;
        P(int x, int y) {
            this.x = x;
            this.y = y;
        } 
    }
    
    public int[] solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = maps[i].charAt(j);
            }
            
        }
        list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char cur = graph[i][j];
                if (cur == 'X') continue;
                list.add(bfs(i, j));
            }
        }
        
        if (list.isEmpty()) {
            return new int[]{-1};
        } else {
            int[] answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);
            return answer;
        }
        
    }
    
    public int bfs(int i, int j) {
        Queue<P> q = new ArrayDeque<>();
        q.add(new P(j, i));
        int total = 0;
        
        while (!q.isEmpty()) {            
            P p = q.poll();
            int val = graph[p.y][p.x];
            graph[p.y][p.x] = 'X';
            if (val == 'X') continue;
            total += val - '0';
            
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int newVal = graph[ny][nx];
                if (newVal == 'X') continue;
                q.add(new P(nx, ny));
            }
        }
         
        return total;
        
    }
}