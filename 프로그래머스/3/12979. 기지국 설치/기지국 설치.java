class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int answer = 0;
        
        for (int i = 0; i <= stations.length; i++) {
            int cur = i == stations.length ? n - 1 : stations[i] - 2 - w;
            int prev = i == 0 ? 0 : stations[i - 1] + w;
            if (cur >= prev) {
                answer += (cur - prev) / (2 * w + 1) + 1;                
            }
        }

        return answer;
    }
}