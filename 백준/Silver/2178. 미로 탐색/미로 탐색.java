import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static Queue<P> q;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class P {
        int x, y;

        P(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = tmp.charAt(j) - '0';
            }
        }

        q = new LinkedList<>();
        q.add(new P(0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            P p = q.poll();
            if (p.x == m - 1 && p.y == n - 1) {
                break;
            }
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && graph[ny][nx] != 0 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    graph[ny][nx] = graph[p.y][p.x] + 1;
                    q.add(new P(ny, nx));
                }
            }
        }

        System.out.println(graph[n - 1][m - 1]);


        bw.flush();
        bw.close();
        br.close();
    }


}
