import java.io.*;
import java.util.*;

public class Main {

    static int k, w, h, ans;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] dxHorse = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dyHorse = {2, 1, -1, -2, -2, -1, 1, 2};

    static class P {
        int x, y, k, dist;

        P(int y, int x, int k, int dist) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "P{" +
                    "x=" + x +
                    ", y=" + y +
                    ", k=" + k +
                    ", dist=" + dist +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        graph = new int[h][w];
        visited = new boolean[h][w][k + 1];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        if (ans == Integer.MAX_VALUE) {
            bw.write(-1 + "\n");
        } else {
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<P> q = new LinkedList<>();

        q.add(new P(0, 0, k, 0));
        visited[0][0][k] = true;

        while (!q.isEmpty()) {
            P p = q.poll();

            if (p.x == w - 1 && p.y == h - 1) {
                ans = Math.min(ans, p.dist);
                return;
            }

            for (int l = 0; l < 4; l++) {
                int nx = p.x + dx[l];
                int ny = p.y + dy[l];

                if (nx < 0 || nx >= w || ny < 0 || ny >= h
                        || graph[ny][nx] == 1 || visited[ny][nx][p.k]) continue;

                visited[ny][nx][p.k] = true;
                q.add(new P(ny, nx, p.k, p.dist + 1));
            }

            if (p.k > 0) {
                for (int l = 0; l < 8; l++) {
                    int nxHorse = p.x + dxHorse[l];
                    int nyHorse = p.y + dyHorse[l];

                    if (nxHorse < 0 || nxHorse >= w || nyHorse < 0 || nyHorse >= h
                            || graph[nyHorse][nxHorse] == 1 || visited[nyHorse][nxHorse][p.k - 1])
                        continue;

                    visited[nyHorse][nxHorse][p.k - 1] = true;
                    q.add(new P(nyHorse, nxHorse, p.k - 1, p.dist + 1));

                }
            }
        }
    }


}
