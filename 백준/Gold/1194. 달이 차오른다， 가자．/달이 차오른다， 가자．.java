import java.io.*;
import java.util.*;

public class Main {

    static int n, m, ans, startX, startY;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] graph;
    static boolean[][][] visited;

    static class P {
        int x, y, dist, keys;

        P(int y, int x, int dist, int keys) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.keys = keys;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        visited = new boolean[n][m][(1 << 6)];
        ans = -1;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j);
                if (graph[i][j] == '0') {
                    startX = j;
                    startY = i;
                }
            }
        }

        bfs();
        
        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<P> q = new LinkedList<>();
        q.add(new P(startY, startX, 0, 0));
        visited[startY][startX][0] = true;

        while (!q.isEmpty()) {
            P p = q.poll();
//            System.out.println(p.y + " " + p.x + " " + p.keys + " " + idx);

            if (graph[p.y][p.x] == '1') {
                ans = p.dist;
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || graph[ny][nx] == '#') continue;

                if (visited[ny][nx][p.keys]) continue;

                if (graph[ny][nx] == '.' || graph[ny][nx] == '0' || graph[ny][nx] == '1') {
                    visited[ny][nx][p.keys] = true;
                    q.add(new P(ny, nx, p.dist + 1, p.keys));

                } else if (Character.isLowerCase(graph[ny][nx])) {
                    int charIdx = graph[ny][nx] - 97;
                    if ((p.keys & (1 << charIdx)) == 0) {
                        int newKeys = p.keys | (1 << charIdx);
                        visited[ny][nx][newKeys] = true;
                        q.add(new P(ny, nx, p.dist + 1, newKeys));
                    } else {
                        visited[ny][nx][p.keys] = true;
                        q.add(new P(ny, nx, p.dist + 1, p.keys));
                    }

                } else if (Character.isUpperCase(graph[ny][nx])) {
                    int charIdx = graph[ny][nx] - 65;
                    if ((p.keys & (1 << charIdx)) != 0) {
                        visited[ny][nx][p.keys] = true;
                        q.add(new P(ny, nx, p.dist + 1, p.keys));
                    }
                }

            }

        }


    }

}
