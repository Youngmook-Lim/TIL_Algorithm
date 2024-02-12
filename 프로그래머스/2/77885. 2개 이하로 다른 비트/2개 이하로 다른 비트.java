import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long cur = numbers[i];
            long target;
            if (cur % 2 == 0) {
                target = cur + 1;
            } else {
                long tmp = 1;
                while (true) {
                    if ((cur & tmp) == 0) break;
                    tmp = tmp << 1;
                }
                target = cur + (tmp >> 1);
            }
            answer[i] = target;
        }
        
        return answer;
    }

}