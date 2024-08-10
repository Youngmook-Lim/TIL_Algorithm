import java.util.*;

class Solution {
    
    char[][] graph;
    boolean[][] visited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int n, m;
    int sI, sJ, lI, lJ;
    
    class P {
        int x, y, n;
        P(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }
    
    public int solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        graph = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = maps[i].charAt(j);
                if (graph[i][j] == 'S') {
                    sI = i;
                    sJ = j;
                } else if (graph[i][j] == 'L') {
                    lI = i;
                    lJ = j;
                }
            }
        }
        
        int answer = 0;
        
        int toLever = bfs(sI, sJ, 'L');
        if (toLever == -1) {
            return -1;
        }
        answer += toLever;
        
        int toExit = bfs(lI, lJ, 'E');
        if (toExit == -1) {
            return -1;
        }
        answer += toExit;
        
        return answer;
    }
    
    int bfs(int y, int x, char type) {
        visited = new boolean[n][m];
        
        visited[y][x] = true;
        
        Queue<P> q = new ArrayDeque<>();
        q.add(new P(x, y, 0));
        
        while (!q.isEmpty()) {
            P p = q.poll();
            
            if (graph[p.y][p.x] == type) {
                return p.n;
            }
            
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (graph[ny][nx] == 'X') continue;
                if (visited[ny][nx]) continue;
                
                visited[ny][nx] = true;
                q.add(new P(nx, ny, p.n + 1));
            }
        }
        
        return -1;
        
    }
}