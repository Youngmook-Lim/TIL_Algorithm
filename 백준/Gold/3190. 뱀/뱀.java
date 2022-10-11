import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, k, l, time;
    static int[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static P[] list;
    static Queue<Integer> tailTime;

    static class P {
        int x;
        char c;

        public P(int x, char c) {
            this.x = x;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        tailTime = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            graph[y][x] = -1;
        }
        graph[0][0] = 1;
        l = Integer.parseInt(br.readLine());
        list = new P[l];
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            list[i] = new P(x, c);
        }

        int curDir = 0;
        int curX = 0;
        int curY = 0;
        int curIdx = 0;
        int lastDir = 0;
        int lastX = 0;
        int lastY = 0;
        int lastIdx = 0;
        int length = 1;

        while (true) {
            time++;
            curX += dx[curDir];
            curY += dy[curDir];
            if (curX >= n || curX < 0 || curY >= n || curY < 0 || graph[curY][curX] == 1) break;
            if (graph[curY][curX] == -1) {
                graph[curY][curX] = 1;
                length++;
            } else {
                graph[curY][curX] = 1;
                graph[lastY][lastX] = 0;
                lastX += dx[lastDir];
                lastY += dy[lastDir];
            }
            if (curIdx < l && list[curIdx].x == time) {
                if (list[curIdx].c == 'D') {
                    curDir = (curDir + 1) % 4;
                } else {
                    curDir = (curDir + 3) % 4;
                }
                curIdx++;
            }

            if (lastIdx < l && list[lastIdx].x == time - length + 1) {
                if (list[lastIdx].c == 'D') {
                    lastDir = (lastDir + 1) % 4;
                } else {
                    lastDir = (lastDir + 3) % 4;
                }
                lastIdx++;
            }

        }

        System.out.println(time);

        br.close();
    }


}

