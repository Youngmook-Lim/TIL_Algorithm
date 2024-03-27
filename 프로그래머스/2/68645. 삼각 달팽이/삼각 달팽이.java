import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] adj = new int[n + 1][];
        for (int i = 1; i <= n; i++) {
            adj[i] = new int[i];
        }
        final int N = n * (n + 1) / 2;
        int direction = 0; // 0: 아래, 1: 오른쪽, 2: 위
        int limit = n;
        int cnt = 0;
        int idx = 0;
        int size = 0;
        for (int i = 1; i <= N; i++) {         
            switch(direction) {
                case 0:
                    idx++;
                    adj[idx][size] = i;
                    break;
                case 1:
                    adj[idx][cnt + size + 1] = i;
                    break;
                case 2:
                    idx--;
                    adj[idx][idx - size - 1] = i;
                    break;
            }
            // System.out.println(i + " added to level " + idx);
            
            cnt++;
            if (cnt == limit) {
                direction = (direction + 1) % 3;
                if (direction == 0) {
                    size++;
                }
                cnt = 0;
                limit--;
            }
        }
        // for (int[] arr : adj) {
        //     System.out.println(Arrays.toString(arr));
        // }
        int[] answer = new int[N];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < adj[i].length; j++) {
                answer[index++] = adj[i][j];
            }
        }
        return answer;
    }
}