import java.io.*;
import java.util.*;

public class Main {

    static int n, x, y, xx, yy, ans;
    static int[][] board;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static class Pos {
        int x, y, cnt;

        Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            ans = 0;

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            xx = Integer.parseInt(st.nextToken());
            yy = Integer.parseInt(st.nextToken());

            bfs(x, y);

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    } // main

    static void bfs(int j, int i) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(j, i, 0));
        board[i][j] = 1;
        while (!q.isEmpty()) {
            Pos pos = q.poll();

            if (xx == pos.x && yy == pos.y) {
                ans = pos.cnt;
                return;
            }
            for (int k = 0; k < 8; k++) {
                int nx = pos.x + dx[k];
                int ny = pos.y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[ny][nx] == 0) {
                    board[ny][nx] = 1;
                    q.add(new Pos(nx, ny, pos.cnt + 1));
                }
            }
        }
    }
}