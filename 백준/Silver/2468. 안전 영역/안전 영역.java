import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n;
    static int[][] land;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int ans = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        land = new int[n][n];
        visited = new boolean[n][n];

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                max = Integer.max(max, land[i][j]);
                min = Integer.min(min, land[i][j]);
            }
        }

        for (int k = min - 1; k < max; k++) {
            visited = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (land[i][j] > k && !visited[i][j]) {
                        bfs(i, j, k);
                        cnt++;
                    }
                }
            }

            ans = Integer.max(ans, cnt);
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int y, int x, int k) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x, y));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx] && land[ny][nx] > k) {
                    q.add(new Pair(nx, ny));
                    visited[ny][nx] = true;
                }
            }

        }

    }

}


