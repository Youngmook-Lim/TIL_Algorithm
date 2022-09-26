import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k;
    static int[][] graph, prefix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][m + 1];
        prefix = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 구하기
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                prefix[i][j] = graph[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        k = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < k; tc++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int sum = prefix[y][x] - prefix[y][j - 1] - prefix[i - 1][x] + prefix[i - 1][j - 1];

            System.out.println(sum);

        }

        br.close();
    }


}
