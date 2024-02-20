class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int answer = 0;
        
        for (int i = 0; i < stations.length; i++) {
            int cur = stations[i] - 2 - w;
            int prev = i == 0 ? 0 : stations[i - 1] + w;
            // System.out.println((cur - prev) / (w + 1));
            if (cur >= prev) {
                answer += (cur - prev) / (2 * w + 1) + 1;                
            }
        }
        
        int cur = n - 1;
        int prev = stations[stations.length - 1] + w;
        
        if (cur >= prev) {
            answer += (cur - prev) / (2 * w + 1) + 1;        
        }

        return answer;
    }
}