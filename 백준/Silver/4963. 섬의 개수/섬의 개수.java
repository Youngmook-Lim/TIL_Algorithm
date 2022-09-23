import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int w, h, ans;
    static int[][] island;
    static int[] dx = {1, -1, 0, 0, 1, -1, -1, 1};
    static int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            island = new int[h][w];
            ans = 0;

            if (w == 0 && h == 0) break;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (island[i][j] == 1) {
                        dfs(i, j);
                        ans++;
                    }
                }
            }

            System.out.println(ans);

        }

        br.close();
    }

    static void dfs(int y, int x) {
        island[y][x] = 0;

        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;

            if (island[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }

}