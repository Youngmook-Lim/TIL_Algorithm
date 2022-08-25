import java.io.*;
import java.util.*;

public class Main {

    static int n, l, r, num, ans;
    static boolean flag = true;
    static int[][] graph, visited;
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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new int[n][n];
            flag = false;
            num = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 0) {
                        int[] tmp = bfsMark(i, j, num++);
                        bfs(i, j, tmp[0], tmp[1]);
                        num++;
                    }
                }
            }

            if (flag) {
                ans++;
            } else {
                break;
            }
        }
        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    } // main

    static void bfs(int i, int j, int total, int freq) {
        Queue<P> q = new LinkedList<>();
        q.add(new P(i, j));
        int avg = total / freq;
        graph[i][j] = avg;
        visited[i][j] = num;

        while (!q.isEmpty()) {
            P p = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[ny][nx] == num - 1) {
                    graph[ny][nx] = avg;
                    visited[ny][nx] = num;
                    q.add(new P(ny, nx));
                }
            }
        }
    }

    static int[] bfsMark(int i, int j, int num) {
        Queue<P> q = new LinkedList<>();
        q.add(new P(i, j));
        visited[i][j] = num;
        int total = graph[i][j];
        int freq = 1;

        while (!q.isEmpty()) {
            P p = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[ny][nx] == 0) {
                    int dif = Math.abs(graph[ny][nx] - graph[p.y][p.x]);
                    if (dif >= l && dif <= r) {
                        flag = true;
                        visited[ny][nx] = num;
                        total += graph[ny][nx];
                        freq++;
                        q.add(new P(ny, nx));
                    }
                }
            }
        }
        return new int[]{total, freq};
    }
}