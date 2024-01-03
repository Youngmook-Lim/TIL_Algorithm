import java.util.*;

class Solution {
    class P {
        int n, idx;
        P(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }
    }
    
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        Stack<P> stack = new Stack<>();
        
        stack.push(new P(prices[0], 0));
        
        for (int i = 1; i < prices.length; i++) {
            int next = prices[i];
            if (stack.peek().n > next) {
                while (!stack.isEmpty()) {
                    if (prices[i] < stack.peek().n) {
                        P p = stack.pop();
                        answer[p.idx] = i - p.idx;  
                    } else {
                        break;
                    }
                }
            }
            stack.push(new P(next, i));
        }
        
        while (!stack.isEmpty()) {
            P p = stack.pop();
            answer[p.idx] = prices.length - 1 - p.idx;  
        }
        
        return answer;
    }
}