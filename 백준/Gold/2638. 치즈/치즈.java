import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 1. (0,0)에서 시작해서 빈칸 다 마킹
 * 2. 마킹되어있는 격자와 접촉하면서 2면 이상 비어있는지 확인
 * 3. 치즈 위치정보를 Queue에 저장
 * */

public class Main {

    static int n, m, numOfCheese, ans;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] graph;
    static boolean[][] isOpenAir;
    static Queue<P> ad;
    static Queue<P> molten;

    static class P {
        int x, y;

        public P(int x, int y) {
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
        isOpenAir = new boolean[n][m];
        ad = new ArrayDeque<>();
        molten = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    ad.add(new P(j, i));
                    numOfCheese++;
                }
            }
        }

        markOpenAir(0, 0);
        while (numOfCheese > 0) {
            meltTheCheese();
            ans++;
        }

        System.out.println(ans);

        br.close();
    }

    static void meltTheCheese() {

        int size = ad.size();
        for (int i = 0; i < size; i++) {
            P p = ad.poll();
            int cnt = 0;
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (isOpenAir[ny][nx] && graph[ny][nx] == 0) cnt++;
            }
            if (cnt >= 2) {
                molten.add(p);
                numOfCheese--;
            } else {
                ad.add(p);
            }
        }
        while (!molten.isEmpty()) {
            P p = molten.poll();
            graph[p.y][p.x] = 0;
            markOpenAir(p.x, p.y);
        }

    }

    static void markOpenAir(int x, int y) {
        Queue<P> q = new ArrayDeque<>();
        q.add(new P(x, y));
        isOpenAir[y][x] = true;
        while (!q.isEmpty()) {
            P p = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (graph[ny][nx] == 1 || isOpenAir[ny][nx]) continue;

                isOpenAir[ny][nx] = true;
                q.add(new P(nx, ny));
            }
        }

    }


}

