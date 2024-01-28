import java.util.*;

class Solution {
    
    int[] dx = {1, 0, 1};
    int[] dy = {0, 1, 1};
    
    boolean[][] visited;
    char[][] graph;
    
    public int solution(int m, int n, String[] board) {
        
        boolean flag = true;
        int cnt = 0;
        
        graph = new char[board.length][];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = board[i].toCharArray();
        }
        
        while (flag) {
            // for (char[] x : graph) {
            //     System.out.println(Arrays.toString(x));
            // }
            // System.out.println();
            visited = new boolean[graph.length][graph[0].length];
            flag = false;
            for (int i = 0; i < graph.length; i++) {
                loop:
                for (int j = 0; j < graph[i].length; j++) {
                    char cur = graph[i][j];
                    if (cur == '*') continue;
                    for (int k = 0; k < 3; k++) {
                        int nj = j + dx[k];
                        int ni = i + dy[k];
                        if (ni >= graph.length || nj >= graph[0].length || cur != graph[ni][nj]) {
                            continue loop;
                        }
                    }
                    flag = true;
                    if (!visited[i][j]) cnt++;
                    visited[i][j] = true;
                    for (int k = 0; k < 3; k++) {
                        int nj = j + dx[k];
                        int ni = i + dy[k];
                        if (!visited[ni][nj]) cnt++;
                        visited[ni][nj] = true;
                    }
                }
            }
            rearrange(graph, visited);
        }
        
        return cnt;
    }
    
    void rearrange(char[][] graph, boolean[][] visited) {
        for (int j = 0; j < graph[0].length; j++) {
            for (int i = graph.length - 1; i >= 0; i--) {
                if (visited[i][j]) {
                    graph[i][j] = '*';
                    continue;
                };
                int ny = i;
                while (ny + 1 < graph.length && graph[ny + 1][j] == '*') {
                    ny++;
                }
                if (ny != i) {
                    graph[ny][j] = graph[i][j];
                    graph[i][j] = '*'; 
                }
            }
        }
    }
}