import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, xStart, yStart;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<P> q;

    static class P {
        int x, y;

        P(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    xStart = j;
                    yStart = i;
                }
            }
        }

        q.add(new P(yStart, xStart));
        graph[yStart][xStart] = 0;
        visited[yStart][xStart] = true;
        while (!q.isEmpty()) {
            P p = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n
                        || visited[ny][nx] || graph[ny][nx] == 0) continue;

                graph[ny][nx] = graph[p.y][p.x] + 1;
                visited[ny][nx] = true;
                q.add(new P(ny, nx));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    graph[i][j] = -1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int[] row : graph) {
            for (int col : row) {
                sb.append(col).append(' ');
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

}
