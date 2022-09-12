import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, ans;
    static char[][] graph;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class P {
        int x, y, dist;
        boolean isBroken;

        P(int y, int x, int dist, boolean isBroken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.isBroken = isBroken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = tmp[j].charAt(0);
            }
        }

        visited = new boolean[2][n][m];
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
        q.add(new P(0, 0, 1, false));
        visited[0][0][0] = true;
        visited[1][0][0] = true;

        while (!q.isEmpty()) {
            P p = q.poll();

            if (p.x == m - 1 && p.y == n - 1) {
                ans = Math.min(ans, p.dist);
                break;
            }

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (p.isBroken && !visited[1][ny][nx]) {
                        if (graph[ny][nx] == '0') {
                            visited[1][ny][nx] = true;
                            q.add(new P(ny, nx, p.dist + 1, true));
                        }
                    } else if (!p.isBroken && !visited[0][ny][nx]) {
                        if (graph[ny][nx] == '1') {
                            visited[1][ny][nx] = true;
                            q.add(new P(ny, nx, p.dist + 1, true));
                        } else {
                            visited[0][ny][nx] = true;
                            q.add(new P(ny, nx, p.dist + 1, false));
                        }
                    }
                }
            }
        }
    }

}