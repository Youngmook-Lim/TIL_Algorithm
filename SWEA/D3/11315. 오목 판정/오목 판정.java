import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static char[][] board;
    static boolean exists;
    static int[] dx = {1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1};

    static void check(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            int cnt = 1;

            while (true) {
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[ny][nx] == 'o') {
                    cnt++;
                    if (cnt == 5) {
                        exists = true;
                        break;
                    }
                    nx += dx[i];
                    ny += dy[i];
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            board = new char[n][n];
            exists = false;

            for (int i = 0; i < n; i++) {
                String[] tmp = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    board[i][j] = tmp[j].charAt(0);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'o') {
                        check(i, j);
                        if (exists) break;
                    }
                }
            }

            bw.write("#" + t + " " + (exists ? "YES" : "NO") + "\n");

        }


        bw.flush();
        bw.close();
        br.close();

    }

}