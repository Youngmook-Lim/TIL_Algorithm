import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }
        
        int time = 0;
        int idx = 0;
        int totalWeight = 0;
        int totalCnt = 0;
        
        while (true) {
            time++;
            // System.out.println(q);
            // System.out.println(totalWeight + " " + totalCnt);
            // System.out.println();
            
            int out = q.poll();
            totalWeight -= out;
            if (out != 0) totalCnt--;
            if (totalCnt == 0 && idx == truck_weights.length) break;
            
            if (idx < truck_weights.length && truck_weights[idx] + totalWeight <= weight && totalCnt < bridge_length) {
                totalWeight += truck_weights[idx];
                totalCnt++;
                q.add(truck_weights[idx++]);
            } else {
                q.add(0);
            }
        }
        
        return time;
    }
}