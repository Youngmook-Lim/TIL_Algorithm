import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer.append(i);
            }
        }
        
        StringBuilder realAnswer = new StringBuilder();
        realAnswer.append(answer.toString()).append('0').append(answer.reverse().toString());
        
        return realAnswer.toString();
    }
}