import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n, white, blue;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, n);

        System.out.println(white);
        System.out.println(blue);

        br.close();
    }

    static void solution(int x, int y, int curN) {
        if (curN == 1) {
            if (graph[y][x] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        int baseColor = graph[y][x];
        boolean flag = true;

        loop:
        for (int i = y; i < y + curN; i++) {
            for (int j = x; j < x + curN; j++) {
                if (graph[i][j] != baseColor) {
                    flag = false;
                    break loop;
                }
            }
        }

        if (flag) {
            if (baseColor == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        int mid = curN / 2;

        solution(x, y, mid);
        solution(x + mid, y, mid);
        solution(x, y + mid, mid);
        solution(x + mid, y + mid, mid);
    }
}
