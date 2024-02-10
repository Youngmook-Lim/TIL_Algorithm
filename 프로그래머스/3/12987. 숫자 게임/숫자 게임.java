import java.util.*;

class Solution {
    
    class P implements Comparable<P> {
        int num, cnt;
        P (int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(P o) {
            return this.num - o.num;
        }
    }
    
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        
        TreeMap<Integer, P> tmap = new TreeMap<>();

        for (int i = 0; i < B.length; i++) {
            if (tmap.containsKey(B[i])) {
                tmap.get(B[i]).cnt++;
            } else {
                tmap.put(B[i], new P(B[i], 1));
            }
        }
        
        int answer = 0;
        
        for (int i = A.length - 1; i >= 0; i--) {
            int cur = A[i];
            Integer winner = tmap.higherKey(cur);
            if (winner != null) {
                answer++;
                if (tmap.get(winner).cnt > 1) {
                    tmap.get(winner).cnt--;
                } else {
                    tmap.remove(winner);
                }
            }
        }

        return answer;
    }
}