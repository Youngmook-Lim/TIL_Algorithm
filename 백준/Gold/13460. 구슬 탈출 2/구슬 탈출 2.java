import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, rx, ry, bx, by, xx, yy;
    static char[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][][][] visited;
    static int num;

    static class B {
        int rx, ry, bx, by;

        public B(int rx, int ry, int bx, int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        visited = new boolean[m][n][m][n];
        num = 1;
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = tmp.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 'B') {
                    bx = j;
                    by = i;
                } else if (graph[i][j] == 'R') {
                    rx = j;
                    ry = i;
                } 
            }
        }

        Queue<B> q = new ArrayDeque<>();
        q.add(new B(rx, ry, bx, by));
        visited[rx][ry][bx][by] = true;

        loop:
        while (true) {
            int size = q.size();
            while (size-- > 0) {
                B b = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nrx = b.rx;
                    int nry = b.ry;
                    int nbx = b.bx;
                    int nby = b.by;
                    int cntR = 0;
                    int cntB = 0;

                    while (graph[nry][nrx] != 'O' && graph[nry + dy[k]][nrx + dx[k]] != '#') {
                        nrx += dx[k];
                        nry += dy[k];
                        cntR++;
                    }
                    while (graph[nby][nbx] != 'O' && graph[nby + dy[k]][nbx + dx[k]] != '#') {
                        nbx += dx[k];
                        nby += dy[k];
                        cntB++;
                    }

                    if (graph[nby][nbx] == 'O') continue;

                    if (graph[nry][nrx] == 'O') break loop;

                    if (nrx == nbx && nry == nby) {
                        if (cntR > cntB) {
                            nrx -= dx[k];
                            nry -= dy[k];
                        } else {
                            nbx -= dx[k];
                            nby -= dy[k];
                        }
                    }

                    if (!visited[nrx][nry][nbx][nby]) {
                        q.add(new B(nrx, nry, nbx, nby));
                        visited[nrx][nry][nbx][nby] = true;
                    }

                }

            }
            num++;
            if (num > 10 || q.isEmpty()) {
                num = -1;
                break loop;
            }
        }

        System.out.println(num);

        br.close();
    }


}

