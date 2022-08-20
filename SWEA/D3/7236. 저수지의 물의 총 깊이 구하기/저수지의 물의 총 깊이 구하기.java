import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static char[][] wells;

    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

    public static int countWells(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (wells[ny][nx] == 'W') {
                cnt++;
            }
        }
        if (cnt == 0) {
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            wells = new char[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    wells[i][j] = st.nextToken().charAt(0);
                }
            }

            int max = 0;

            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (wells[i][j] == 'W') {
                        max = Integer.max(max, countWells(j, i));
                    }
                }
            }
            bw.write("#" + t + " " + max + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}