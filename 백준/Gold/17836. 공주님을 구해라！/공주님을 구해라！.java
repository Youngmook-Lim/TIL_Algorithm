import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, t, ans;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class P {
        int x, y, t;
        boolean hasSword;

        P(int y, int x, int t, boolean hasSword) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.hasSword = hasSword;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        if (ans == 0) {
            bw.write("Fail" + "\n");
        } else {
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<P> q = new LinkedList<>();
        q.add(new P(0, 0, 0, false));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            P p = q.poll();
            if (p.t > t) {
                return;
            }

            if (p.x == m - 1 && p.y == n - 1) {
                ans = p.t;
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                if (graph[ny][nx] == 1) {
                    if (p.hasSword && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        q.add(new P(ny, nx, p.t + 1, true));
                    }
                } else if (graph[ny][nx] == 0) {
                    if (p.hasSword && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        q.add(new P(ny, nx, p.t + 1, true));
                    } else if (!p.hasSword && !visited[ny][nx][0]) {
                        visited[ny][nx][0] = true;
                        q.add(new P(ny, nx, p.t + 1, false));
                    }
                } else {
                    if (!visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        q.add(new P(ny, nx, p.t + 1, true));
                    }
                }
            }
        }
    }


}