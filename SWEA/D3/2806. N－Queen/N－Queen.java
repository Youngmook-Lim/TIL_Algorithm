import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int N; 
    static int[][] map; 
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            ans = 0;
            map = new int[N][N];

            putQueen(0);

            System.out.println("#" + t + " " + ans);
        }

        br.close();
    }

    static void putQueen(int r) {
        if (r == N) {
            ans++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (isPutable(r, c)) { 
                map[r][c] = 1;
                putQueen(r + 1);
                map[r][c] = 0;
            }
        }
    }

    static boolean isPutable(int r, int c) {
        int left = c;
        int right = c;

        for (int i = r - 1; i >= 0; i--) {
            left--;
            right++;

            if (map[i][c] == 1) return false; 
            if (left >= 0 && map[i][left] == 1) return false;
            if (right < N && map[i][right] == 1) return false;
        }
        return true;
    }

}