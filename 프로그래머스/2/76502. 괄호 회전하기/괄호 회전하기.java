import java.util.*;

class Solution {
    public int solution(String s) {

        int answer = 0;
        
        String x = s;
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (i > 0) {
                x = transform(x);
            }
            
            if (check(x)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean check(String x) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            if (i == 0 && (ch == ']' || ch == '}' || ch == ')')) {
                return false;
            }
            
            if (!stack.isEmpty()) {
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else {
                    char prev = stack.peek();
                    if ((prev == '(' && ch == ')') || (prev == '{' && ch == '}') ||
                       (prev == '[' && ch == ']')) {
                        stack.pop();
                    }
                }
            } else {
                stack.push(ch);
            }
            
        }
        
        return stack.isEmpty();
    }
    
    public String transform(String x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < x.length(); i++) {
            sb.append(x.charAt(i));
        }
        sb.append(x.charAt(0));
        return sb.toString();
    }
}