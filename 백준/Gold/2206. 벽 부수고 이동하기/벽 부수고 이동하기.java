import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

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
        String[] inputs = br.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        graph = new char[n][m];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = tmp.charAt(j);
            }
        }

        visited = new boolean[2][n][m];

        bfs();

        if (ans == 0) {
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

        while (!q.isEmpty()) {
            P p = q.poll();

            if (p.x == m - 1 && p.y == n - 1) {
                ans = p.dist;
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (graph[ny][nx] == '0') {
                        if (p.isBroken && !visited[1][ny][nx]) {
                            visited[1][ny][nx] = true;
                            q.add(new P(ny, nx, p.dist + 1, true));
                        } else if (!p.isBroken && !visited[0][ny][nx]) {
                            visited[0][ny][nx] = true;
                            q.add(new P(ny, nx, p.dist + 1, false));
                        }
                    } else {
                        if (!p.isBroken) {
                            visited[1][ny][nx] = true;
                            q.add(new P(ny, nx, p.dist + 1, true));
                        }
                    }

                }
            }
        }
    }

}
