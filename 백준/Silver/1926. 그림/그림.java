import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, m;
    static int cnt, max;

    static class P {
        int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    max = Math.max(max, bfs(j, i));
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);

        br.close();
    }

    static int bfs(int x, int y) {
        visited[y][x] = true;

        Queue<P> q = new ArrayDeque<>();
        q.add(new P(x, y));

        int total = 1;

        while (!q.isEmpty()) {
            P p = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (visited[ny][nx]) continue;
                if (graph[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                total++;
                q.add(new P(nx, ny));
            }
        }

        return total;
    }


}

