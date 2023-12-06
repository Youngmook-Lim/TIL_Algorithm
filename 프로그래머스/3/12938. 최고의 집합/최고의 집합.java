class Solution {
    public int[] solution(int n, int s) {
        
        int tmp = s / n;
        int mod = s % n;
        
        if (tmp == 0) return new int[]{-1};
        
        int[] answer = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int add = mod > 0 ? 1 : 0;
            answer[i] = tmp + add;
            mod--;
        }
        
        return answer;
    }
}