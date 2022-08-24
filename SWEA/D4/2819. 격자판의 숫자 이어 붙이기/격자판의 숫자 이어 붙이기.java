import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static String[][] board;
    static Set<String> set;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            board = new String[4][4];
            set = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    board[i][j] = st.nextToken();
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, "", 0);
                }
            }

            bw.write("#" + t + " " + set.size() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int y, int x, String num, int cnt) {
        if (cnt == 7) {
            set.add(num);
            return;
        }

        num = num.concat(board[y][x]);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                dfs(ny, nx, num, cnt + 1);
            }
        }
    }
}
