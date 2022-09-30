import java.io.*;
import java.util.*;

public class Solution {
    static final int INF = 987654321;
    static int n, ans;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] graph;

    static class P implements Comparable<P> {
        int x, y, dist;

        public P(int y, int x, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(P o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    static boolean[][] visited;
    static int[][] dist;
    static Queue<P> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            graph = new int[n][n];
            dist = new int[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                for (int j = 0; j < n; j++) {
                    graph[i][j] = input.charAt(j) - '0';
                }
            }
            for (int[] x : dist) {
                Arrays.fill(x, INF);
            }

            dijkstra(0, 0);

            sb.append("#").append(t).append(" ").append(dist[n - 1][n - 1]).append("\n");

        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int x, int y) {
        dist[y][x] = 0;
        pq = new PriorityQueue<>();
        pq.add(new P(y, x, 0));

        while (!pq.isEmpty()) {
            P p = pq.poll();

            if (visited[p.y][p.x]) continue;
            visited[p.y][p.x] = true;

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[ny][nx]) continue;

                if (dist[p.y][p.x] + graph[ny][nx] < dist[ny][nx]) {
                    dist[ny][nx] = dist[p.y][p.x] + graph[ny][nx];
                    pq.add(new P(ny, nx, dist[ny][nx]));
                }

            }
        }

    }


}