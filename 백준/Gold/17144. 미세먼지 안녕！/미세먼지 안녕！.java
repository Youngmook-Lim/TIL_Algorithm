import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 1. 리스트에 0 아닌 값들의 좌표 추가 (미세먼지 위치 리스트)
 * 2. 확산 : 큐에 다 넣고 하나씩 꺼내서 4방에 미세먼지 추가된 좌표를 추가
 * 3. 청정 : -1의 좌표를 어디다 저장해 논 다음에 위에꺼 실행, 아래꺼 실행
 * 4. 2,3번 T번 실행
 */

public class Main {

    static int r, c, t, upX, upY, downX, downY, ans;
    static int[][] graph;
    static Queue<P> q;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class P {
        int x, y, value;

        public P(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        ans = 2;
        graph = new int[r][c];
        q = new ArrayDeque<>();
        boolean tmpFlag = false;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == -1) {
                    if (!tmpFlag) {
                        upX = j;
                        upY = i;
                        tmpFlag = true;
                    } else {
                        downX = j;
                        downY = i;
                    }
                } else if (graph[i][j] != 0) {
                    q.add(new P(j, i, graph[i][j]));
                }
            }
        }

        while (t-- > 0) {
            spread();
            clean();
            addNewGas();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans += graph[i][j];
            }
        }

        System.out.println(ans);

        br.close();
    }

    static void spread() {
        while (!q.isEmpty()) {
            P p = q.poll();

            int power = p.value / 5;

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 0 || nx >= c || ny < 0 || ny >= r || graph[ny][nx] == -1) continue;

                graph[ny][nx] += power;
                graph[p.y][p.x] -= power;
            }
        }


    }

    static void clean() {
        // up
        int upYOriginal = upY;
        int upXOriginal = upX;
        while (upY > 0) {
            graph[upY--][upX] = graph[upY][upX];
        }
        while (upX < c - 1) {
            graph[upY][upX++] = graph[upY][upX];
        }
        while (upY < upYOriginal) {
            graph[upY++][upX] = graph[upY][upX];
        }
        while (upX > upXOriginal + 1) {
            graph[upY][upX--] = graph[upY][upX];
        }
        graph[upY][upX--] = 0;
        graph[upY][upX] = -1;

        // down
        int downYOriginal = downY;
        int downXOriginal = downX;
        while (downY < r - 1) {
            graph[downY++][downX] = graph[downY][downX];
        }
        while (downX < c - 1) {
            graph[downY][downX++] = graph[downY][downX];
        }
        while (downY > downYOriginal) {
            graph[downY--][downX] = graph[downY][downX];
        }
        while (downX > downXOriginal + 1) {
            graph[downY][downX--] = graph[downY][downX];
        }
        graph[downY][downX--] = 0;
        graph[downY][downX] = -1;
    }

    static void addNewGas() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (graph[i][j] > 0) {
                    q.add(new P(j, i, graph[i][j]));
                }
            }
        }
    }

}

