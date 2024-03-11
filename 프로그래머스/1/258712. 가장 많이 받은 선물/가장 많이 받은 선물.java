import java.util.*;

class Solution {
    
    int[][] graph;
    
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        
        graph = new int[friends.length + 1][friends.length + 1];
        
        for (int i = 0; i < gifts.length; i++) {
            String[] tmp = gifts[i].split(" ");
            String from = tmp[0];
            String to = tmp[1];
            
            graph[map.get(from)][map.get(to)]++;
        }
        
        for (int i = 0; i < friends.length; i++) {
            int totalY = 0;
            int totalX = 0;
            for (int j = 0; j < friends.length; j++) {
                totalX += graph[i][j];
                totalY += graph[j][i];
            }
            graph[i][friends.length] = totalX;
            graph[friends.length][i] = totalY;
        }
        
        Map<String, Integer> pi = new HashMap<>();
        
        for (int i = 0; i < friends.length; i++) {
            pi.put(friends[i], graph[i][friends.length] - graph[friends.length][i]);
        }
        
        int[] total = new int[friends.length];
        
        for (int i = 0; i < friends.length; i++) { // from
            for (int j = i + 1; j < friends.length; j++) { // to
                if (graph[i][j] > graph[j][i]) {
                    total[i]++;
                } else if (graph[i][j] < graph[j][i]) {
                    total[j]++;
                } else {
                    if (pi.get(friends[i]) > pi.get(friends[j])) {
                        total[i]++;
                    } else if (pi.get(friends[i]) < pi.get(friends[j])) {
                        total[j]++;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(total));
        int answer = 0;
        
        for (int x : total) {
            answer = Math.max(answer, x);
        }
        
        return answer;
    }
}