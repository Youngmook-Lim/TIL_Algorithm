import java.util.*;

class Solution {
    
    int[][] graph;
    boolean[][] visited;
    int x, y;
    
    
    public int solution(String dirs) {
        graph = new int[11][11];
        visited = new boolean[22][22];
        x = 5;
        y = 5;
        int answer = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            char cmd = dirs.charAt(i);
            
            int nx = x;
            int ny = y;
            
            switch (cmd) {
                case 'U':
                    ny = y - 1;
                    break;
                case 'D':
                    ny = y + 1;
                    break;
                case 'R':
                    nx = x + 1;
                    break;
                case 'L':
                    nx = x - 1;
                    break;
            }
            
            // System.out.println("(" + (y - 5) + ", " + (x - 5) + ") -> (" + (ny - 5) + ", " + (nx - 5) + ")");
            
            if (ny < 0 || ny >= 11 || nx < 0 || nx >= 11) continue;
            if (!visited[(y + ny)][x + nx]) answer++;
            
            visited[y + ny][x + nx] = true;
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}