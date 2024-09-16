class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (true) {
            if (wallet[0] >= bill[0] && wallet[1] >= bill[1] 
               || wallet[1] >= bill[0] && wallet[0] >= bill[1]) break;
            int a = bill[0];
            int b = bill[1];
            if (a > b) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        return answer;
    }
}