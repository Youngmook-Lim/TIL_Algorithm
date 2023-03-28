import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static int n, m;
    static int ans, max;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

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
                max = Math.max(max, graph[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(j, i, graph[i][j], 1);
            }
        }

        System.out.println(ans);

        br.close();
    }

    static void dfs(int x, int y, int total, int cnt) {
        if (cnt == 4) {
            ans = Math.max(ans, total);
            return;
        }

        if (ans >= total + max * (4 - cnt)) {
            return;
        }

        visited[y][x] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (visited[ny][nx]) continue;

            if (cnt == 2) {
                visited[ny][nx] = true;
                dfs(x, y, total + graph[ny][nx], cnt + 1);
                visited[ny][nx] = false;
                visited[y][x] = true;
            }

            dfs(nx, ny, total + graph[ny][nx], cnt + 1);
        }

        visited[y][x] = false;
    }


}

