import java.io.*;
import java.util.*;

public class Main {

    static int m, n, k, cnt;
    static int[][] paper;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> list;

    static class P {
        int x, y;

        P(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        paper = new int[m][n];
        list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int xx = Integer.parseInt(st.nextToken());
            int yy = Integer.parseInt(st.nextToken());

            for (int p = y; p < yy; p++) {
                for (int q = x; q < xx; q++) {
                    paper[p][q] = -1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (paper[i][j] == 0) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        Collections.sort(list);

        bw.write(cnt + "\n");
        for (int a : list) {
            bw.write(a + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    } // main

    static void bfs(int i, int j) {
        Queue<P> q = new LinkedList<>();
        int size = 0;
        paper[i][j] = ++size;
        q.add(new P(j, i));
        while (!q.isEmpty()) {
            P p = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && paper[ny][nx] == 0) {
                    paper[ny][nx] = ++size;
                    q.add(new P(nx, ny));
                }
            }
        }
        list.add(size);
    }

}