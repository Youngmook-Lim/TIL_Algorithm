import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] graph;
    static boolean[][] isCloud;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static Queue<P> cloudList;

    static class P {
        int x, y;

        public P(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        cloudList = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            simulation(d, s);
        }
        int ans = calculateSum();

        System.out.println(ans);

        br.close();
    }

    static int calculateSum() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += graph[i][j];
            }
        }
        return ans;
    }

    static void simulation(int d, int s) {
        moveCloudAndRain(d, s);
        checkDiagonal();
        formNewClouds();
    }

    static void formNewClouds() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isCloud[i][j] && graph[i][j] >= 2) {
                    cloudList.add(new P(i, j));
                    graph[i][j] -= 2;
                }
            }
        }
    }

    static void checkDiagonal() {
        int size = cloudList.size();
        while (size-- > 0) {
            P p = cloudList.poll();
            for (int i = 0; i < 4; i++) {
                int d = i * 2 + 1;
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (graph[ny][nx] > 0) graph[p.y][p.x]++;
            }
        }
    }

    static void moveCloudAndRain(int d, int s) {
        isCloud = new boolean[n][n];
        int size = cloudList.size();
        while (size-- > 0) {
            P p = cloudList.poll();
            int nx, ny;
            int resX = p.x + dx[d] * s;
            if (resX < 0) {
                nx = (n - (-resX % n)) % n;
            } else {
                nx = resX % n;
            }
            int resY = p.y + dy[d] * s;
            if (resY < 0) {
                ny = (n - (-resY % n)) % n;
            } else {
                ny = resY % n;
            }
            isCloud[ny][nx] = true;
            graph[ny][nx]++;
            cloudList.add(new P(ny, nx));
        }
    }

    static void init() {
        cloudList.add(new P(n - 1, 0));
        cloudList.add(new P(n - 1, 1));
        cloudList.add(new P(n - 2, 0));
        cloudList.add(new P(n - 2, 1));
    }

}
