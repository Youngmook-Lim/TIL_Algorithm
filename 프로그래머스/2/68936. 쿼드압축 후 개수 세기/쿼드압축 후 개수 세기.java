import java.util.*;

class Solution {
    
    int zero, one;
    
    public int[] solution(int[][] arr) {
        
        check(arr, 0, 0, arr.length);
        
        int[] answer = {zero, one};
        return answer;
    }
    
    public void check(int[][] arr, int x, int y, int n) {
        
        if (n == 1) {
            if (arr[y][x] == 1) {
                one++;
            } else {
                zero++;
            }
            return;
        }
        
        int standard = arr[y][x];
        boolean flag = true;
        
        loop:
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (i == y && j == x) continue;
                if (arr[i][j] != standard) {
                    flag = false;
                    break loop;
                }
            }
        }
        
        if (flag) {
            if (standard == 1) {
                one++;
            } else {
                zero++;
            }
        } else {
            check(arr, x, y, n / 2);
            check(arr, x + n / 2, y, n / 2);
            check(arr, x, y + n / 2, n / 2);
            check(arr, x + n / 2, y + n / 2, n / 2);
        }
        
    }
}