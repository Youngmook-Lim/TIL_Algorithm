import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length - 1;
        int answer = 0;
        
        while (start <= end) {
            int sum = people[start] + people[end];
            
            if (sum <= limit) {
                start++;
            }
            
            end--;
            answer++;
        }
        

        return answer;
    }
}