import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, d, ans, idx;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        idx = 2;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) {
                    defend(new int[]{i, j, k});
                }
            }
        }

        System.out.println(ans);

        br.close();
    }

    static void defend(int[] archers) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = graph[i][j];
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int startX : archers) {
                int startY = n - 1 - i;
                cnt += shoot(startX, startY, tmp);
            }
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < m; j++) {
                    if (tmp[k][j] == 2) {
                        tmp[k][j] = 0;
                    }
                }
            }
        }
        ans = Math.max(ans, cnt);
        idx++;
    }

    static int shoot(int x, int y, int[][] tmp) {
        int range = 0;
        while (range < d) {
            for (int i = 0; i < range * 2 + 1; i++) {
                int shootX = x - range + i;
                int shootY = y - range + Math.abs(i - range);

                if (shootX < 0 || shootX >= m || shootY < 0 || shootY >= n) continue;

                if (tmp[shootY][shootX] != 0) {
                    if (tmp[shootY][shootX] != 2) {
                        tmp[shootY][shootX] = 2;
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
            range++;
        }
        return 0;
    }
}