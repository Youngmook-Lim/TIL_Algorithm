import java.util.*;

class Solution {
    
    Queue<Integer> pq;
    
    public int[] solution(int k, int[] score) {
        pq = new PriorityQueue<>();
        int[] answer = new int[score.length];
        
        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);
            
            if (pq.size() > k) {
                pq.poll();
            }
           
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}