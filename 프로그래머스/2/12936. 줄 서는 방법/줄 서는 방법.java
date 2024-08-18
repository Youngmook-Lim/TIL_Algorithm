import java.util.*;

class Solution {
    public int[] solution(int n, long k) {

        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        long a = 1;
        long b = n - 1;
        int c = 1;
        
        for (long i = 1; i < n; i++) {
            a *= i;
        }
        
        while (list.size() < n) {
            if (visited[c]) {
                c++;
                continue;
            }
            long tmp = k - a;
            if (tmp <= 0) {
                list.add(c);
                visited[c] = true;
                if (b > 0) {
                    a /= b--;                    
                }
                c = 1;
            } else {
                c++;
                k -= a;
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}