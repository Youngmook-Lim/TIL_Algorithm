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
    static final int N = 10;
    static final int PAPERNUMBER = 5;

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

        graph = new int[N][N];
        list = new ArrayList<>();
        papers = new int[PAPERNUMBER + 1];
        for (int i = 1; i <= PAPERNUMBER; i++) {
            papers[i] = PAPERNUMBER;
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

//        for (int[] x : graph) {
//            System.out.println(Arrays.toString(x));
//        }
//        System.out.println();

        if (idx == list.size()) {
            success = true;
            ans = Math.min(ans, cnt);
            return;
        }

        P p = list.get(idx);


        if (graph[p.y][p.x] == 1) {
            for (int i = 1; i <= PAPERNUMBER; i++) {
                if (checkFit(p.y, p.x, i) && papers[i] > 0) {
                    markFit(p.y, p.x, i);
                    papers[i]--;
                    dfs(idx + 1, cnt + 1);
                    papers[i]++;
                    markFitReverse(p.y, p.x, i);
                }
            }
        } else {
            dfs(idx + 1, cnt);
        }
    }

    static boolean checkFit(int y, int x, int size) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (i >= 10 || i < 0 || j >= 10 || j < 0) {
                    return false;
                }
                if (graph[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void markFit(int y, int x, int size) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                graph[i][j] = size + 1;
            }
        }
    }

    static void markFitReverse(int y, int x, int size) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                graph[i][j] = 1;
            }
        }
    }

}