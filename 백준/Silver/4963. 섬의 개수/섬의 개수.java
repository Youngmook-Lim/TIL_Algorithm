import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int w;
    static int h;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0, 1, -1, -1, 1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int cnt = 0;

            map = new int[h][w];

            if (w == 0 && h == 0) break;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);

        }
        br.close();

    }

    static void bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x, y));
        map[y][x] = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 8; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (nx >= 0 && nx < w && ny >= 0 && ny < h && map[ny][nx] == 1) {
                    q.add(new Pair(nx, ny));
                    map[ny][nx] = 0;
                }
            }

        }
    }

}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}