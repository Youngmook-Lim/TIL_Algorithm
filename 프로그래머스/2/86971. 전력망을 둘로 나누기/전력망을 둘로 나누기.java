import java.util.*;

class Solution {
    
    boolean[] visited;
    List<Integer>[] adj;
    int[] sums;
    int tmp;
    
    public int solution(int n, int[][] wires) {
        
        visited = new boolean[n + 1];
        sums = new int[2];
        adj = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] arr : wires) {
            adj[arr[0]].add(arr[1]);
            adj[arr[1]].add(arr[0]);
        }
        tmp = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n - 1; i++) {
            // System.out.println("i = " + i);
            visited = new boolean[n + 1];
            int a = wires[i][0];
            int b = wires[i][1];
            adj[a].remove(Integer.valueOf(b));
            adj[b].remove(Integer.valueOf(a));
            cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    tmp = 0;
                    dfs(j);
                    sums[cnt++] = tmp;
                    if (cnt == 2) break;
                }
            }
            adj[a].add(b);
            adj[b].add(a);
            min = Math.min(min, Math.abs(sums[1] - sums[0]));
            // System.out.println("min is " + min);
        }
        
        return min;
    }
    
    void dfs(int node) {
        // System.out.println(node);
        tmp++;
        visited[node] = true;
        for (int x : adj[node]) {
            if (!visited[x]) {
                dfs(x);
            }
        }
    }
}