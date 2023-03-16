import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int[][] graph;
    static int N, L;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            checkLateral(i);
            checkHorizontal(i);
        }

        System.out.println(ans);

        br.close();
    }

    static void checkLateral(int y) {

        int cur = graph[y][0];
        int cnt = 1;
        boolean flag = false;

        for (int i = 1; i < N; i++) {
            if (graph[y][i] == cur) {
                cnt++;
            } else {
                if (flag) return;

                if (graph[y][i] > cur) {
                    if (graph[y][i] - cur > 1) return;
                    if (cnt < L) return;
                } else {
                    if (cur - graph[y][i] > 1) return;
                    flag = true;
                }

                cnt = 1;
                cur = graph[y][i];

            }

            if (flag && cnt == L) {
                cnt = 0;
                flag = false;
            }
        }

        if (flag && cnt < L) return;

        ans++;
//        System.out.println("Lateral no." + y + " : OK");
    }

    static void checkHorizontal(int x) {

        int cur = graph[0][x];
        int cnt = 1;
        boolean flag = false;

        for (int i = 1; i < N; i++) {
            if (graph[i][x] == cur) {
                cnt++;

            } else {
                if (flag) return;

                if (graph[i][x] > cur) {
                    if (graph[i][x] - cur > 1) return;
                    if (cnt < L) return;
                } else {
                    if (cur - graph[i][x] > 1) return;
                    flag = true;
                }

                cnt = 1;
                cur = graph[i][x];
            }

            if (flag && cnt == L) {
                cnt = 0;
                flag = false;
            }
        }

        if (flag && cnt < L) return;

        ans++;
//        System.out.println("Horizontal no." + x + " : OK");

    }

}


