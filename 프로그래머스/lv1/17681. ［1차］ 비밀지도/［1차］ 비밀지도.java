class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        for (int i = 0; i < n; i++) {
            arr1[i] = arr1[i] | arr2[i];
        }
        
        String[] answer = new String[n];
        StringBuilder sb;
        
        for (int k = 0; k < n; k++) {
            sb = new StringBuilder();
            for (int i = n-1; i >= 0; i--) {
                if ((arr1[k] & (1 << i)) != 0) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[k] = sb.toString();
        }
        return answer;
    }
}