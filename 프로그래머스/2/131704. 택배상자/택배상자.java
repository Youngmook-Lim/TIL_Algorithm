import java.util.*;

class Solution {
    public int solution(int[] order) {
        int n = order.length;
        
        int primary = 1;
        Stack<Integer> secondaryStack = new Stack<>();
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {

            int cur = order[i];
            if (cur >= primary) {
                for (int j = primary; j < cur; j++) {
                    secondaryStack.push(j);
                }
                primary = cur + 1;
                answer++;
            } else {
                if (secondaryStack.peek() == cur) {
                    secondaryStack.pop();
                    answer++;
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}