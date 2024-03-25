class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum = 0;
        long sum1 = 0;
        long sum2 = 0;
        int n = queue1.length;
        int[] q1 = new int[n * 2];
        int[] q2 = new int[n * 2];
        for (int i = 0; i < n; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1[i] = queue1[i];
            q2[i] = queue2[i];
        }
        sum = sum1 + sum2;
        
        if (sum % 2 != 0) return -1;
        
        sum /= 2;
        
        int idx1 = 0;
        int idx2 = 0;
        int cnt = 0;
        while (idx1 != 2 * n && idx2 != 2 * n) {
            if (sum1 == sum2) {
                return cnt;
            } else if (sum1 > sum2) {
                if (idx1 != 2 * n) {
                    sum1 -= q1[idx1];                   
                    sum2 += q1[idx1];
                    q2[(n + idx1) % (2 * n)] = q1[idx1++];
                }
            } else {
                if (idx2 != 2 * n) {
                    sum1 += q2[idx2];
                    sum2 -= q2[idx2];
                    q1[(n + idx2) % (2 * n)] = q2[idx2++];
                }
            }
            cnt++;
        }
        
        return -1;
    }
}