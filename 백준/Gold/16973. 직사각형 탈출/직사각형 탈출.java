import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, h, w, sr, sc, fr, fc, ans;
    static int[][] graph;
    static int[][] prefix;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class P {
        int x, y, cnt;

        P(int y, int x, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;

        graph = new int[n + 1][m + 1];
        prefix = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = graph[i][j] + prefix[i - 1][j]
                        + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        fr = Integer.parseInt(st.nextToken());
        fc = Integer.parseInt(st.nextToken());


        bfs(sr, sc);

        if (ans != Integer.MAX_VALUE) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }


        br.close();
    }

    static void bfs(int i, int j) {
        Queue<P> q = new LinkedList<>();
        q.add(new P(i, j, 0));
        graph[i][j] = 2;
        while (!q.isEmpty()) {
            P p = q.poll();

            if (p.x == fc && p.y == fr) {
                ans = Math.min(ans, p.cnt);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 1 || ny < 1 || nx > m || ny > n || graph[ny][nx] == 2) continue;

                if (checkPossible(ny, nx, h, w)) {
                    graph[ny][nx] = 2;
                    q.add(new P(ny, nx, p.cnt + 1));
                }
            }
        }
    }

    static boolean checkPossible(int y, int x, int h, int w) {
        if (y + h - 1 > n || x + w - 1 > m) return false;
        return prefix[y + h - 1][x + w - 1] - prefix[y + h - 1][x - 1]
                - prefix[y - 1][x + w - 1] + prefix[y - 1][x - 1] == 0;
    }
}
