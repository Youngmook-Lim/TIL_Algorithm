class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int n = sequence.length;
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = arr[i] + sequence[i];
        }
        int start = n - 1;
        int end = n;
        int max = 0;
        int len = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (start >= 0 && end >= 0) {
            int cur = arr[end] - arr[start];
            if (cur == k) {
                int l = end - start;
                if (l <= len) {
                    len = l;
                    answer[0] = start ;
                    answer[1] = end - 1;
                }
                start--;
            } else if (cur < k) {
                start--;
            } else {
                end--;
            }
        }
        
        return answer;
    }
}