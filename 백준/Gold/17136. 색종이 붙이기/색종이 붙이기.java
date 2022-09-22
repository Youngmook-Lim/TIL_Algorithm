import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean success;
    static List<P> list;
    static int[] papers;

    static class P {
        int x, y;

        P(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        graph = new int[10][10];
        list = new ArrayList<>();
        papers = new int[5 + 1];
        for (int i = 1; i <= 5; i++) {
            papers[i] = 5;
        }
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    list.add(new P(i, j));
                }
            }
        }

        dfs(0, 0);

        if (success) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }

        br.close();
    }

    static void dfs(int idx, int cnt) {

        if (idx == list.size()) {
            success = true;
            ans = Math.min(ans, cnt);
            return;
        }

        P p = list.get(idx);
        int maxSize = checkMaxFit(p.y, p.x);

        if (graph[p.y][p.x] == 1) {
            for (int i = 1; i <= maxSize; i++) {
                if (papers[i] > 0) {
                    markFit(p.y, p.x, i, 0);
                    papers[i]--;
                    dfs(idx + 1, cnt + 1);
                    papers[i]++;
                    markFit(p.y, p.x, i, 1);
                }
            }
        } else {
            dfs(idx + 1, cnt);
        }
    }

    static int checkMaxFit(int y, int x) {
        int size = 1;

        loop:
        while (size <= 5) {
            for (int i = y; i < y + size; i++) {
                for (int j = x; j < x + size; j++) {
                    if (i >= 10 || i < 0 || j >= 10 || j < 0) {
                        break loop;
                    }
                    if (graph[i][j] != 1) {
                        break loop;
                    }
                }
            }
            size++;
        }
        return --size;
    }

    static void markFit(int y, int x, int size, int type) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (type == 0) {
                    graph[i][j] = size + 1;
                } else {
                    graph[i][j] = 1;
                }
            }
        }
    }

}