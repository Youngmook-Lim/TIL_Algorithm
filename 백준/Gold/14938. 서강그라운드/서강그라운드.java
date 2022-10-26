import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. 플로이드-워셜로 모든 정점 간 최단거리를 구한 후 정점마다 수색범위보다 적은 정점의 템을 더해준다.
 * */
public class Main {

    static final int INF = 987654321;
    static int n, m, r, ans;
    static int[] itemsList;
    static int[][] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        itemsList = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemsList[i] = Integer.parseInt(st.nextToken());
        }

        dist = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            dist[a][b] = len;
            dist[b][a] = len;
        }

        floydWarshall();

        for (int i = 1; i <= n; i++) {
            int total = itemsList[i];
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] <= m) {
                    total += itemsList[j];
                }
            }
            ans = Math.max(ans, total);
        }

        System.out.println(ans);

        br.close();
    }

    static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

}

