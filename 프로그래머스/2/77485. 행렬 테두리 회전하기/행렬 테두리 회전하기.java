import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] graph = makeGraph(rows, columns);
        
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int r1 = query[0] - 1;
            int c1 = query[1] - 1;
            int r2 = query[2] - 1;
            int c2 = query[3] - 1;
            
            answer[i] = spin(r1, c1, r2, c2, graph);
        }
        
        return answer;
    }
    
    public int spin(int r1, int c1, int r2, int c2, int[][] graph) {
        
        int tmp = graph[r1][c1];
        int min = tmp;
        
        for (int i = r1; i < r2; i++) {
            graph[i][c1] = graph[i + 1][c1];
            min = Math.min(min, graph[i][c1]);
        }
        for (int i = c1; i < c2; i++) {
            graph[r2][i] = graph[r2][i + 1];
            min = Math.min(min, graph[r2][i]);
        }
        for (int i = r2; i > r1; i--) {
            graph[i][c2] = graph[i - 1][c2];
            min = Math.min(min, graph[i][c2]);
        }
        for (int i = c2; i > c1; i--) {
            graph[r1][i] = graph[r1][i - 1];
            min = Math.min(min, graph[r1][i]);
        }
        graph[r1][c1 + 1] = tmp;
        
        return min;
    }
    
    public int[][] makeGraph(int rows, int columns) {
        
        int[][] graph = new int[rows][columns];
        
        for (int i = 0; i < rows * columns; i++) {
            int r = i / columns;
            int c = i % columns;
            graph[r][c] = i + 1;
        }
        return graph;
    }
}