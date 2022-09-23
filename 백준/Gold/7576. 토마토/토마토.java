import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n, cnt, ans;
    static int[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class P {
        int x, y, day;

        P(int y, int x, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 0) cnt++;
            }
        }

        Queue<P> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    q.add(new P(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {

            P p = q.poll();

            ans = p.day;

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && graph[ny][nx] == 0) {
                    graph[ny][nx] = p.day + 1;
                    cnt--;
                    q.add(new P(ny, nx, p.day + 1));
                }
            }
        }

        if (cnt > 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

        br.close();
    }


}