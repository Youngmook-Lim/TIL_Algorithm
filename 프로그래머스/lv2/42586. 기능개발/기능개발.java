

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int i = progresses.length - 1; i >= 0; i--) {
            stack.push((100 - progresses[i] - 1) / speeds[i] + 1);
        }

        while (!stack.isEmpty()) {
            int cnt = 1;
            int a = stack.pop();

            while (!stack.isEmpty() && a >= stack.peek()) {
                stack.pop();
                cnt++;
            }
            list.add(cnt);
        }


        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
