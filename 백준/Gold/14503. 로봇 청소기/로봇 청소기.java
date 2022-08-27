import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m;
    static int r, c, d;
    static int[][] graph;
    static int[] dc = {-1, 0, 1, 0};
    static int[] dr = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        if (d == 1) {
            d = 3;
        } else if (d == 3) {
            d = 1;
        }
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d, 1);
        
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int r, int c, int d, int depth) throws IOException {

        graph[r][c] = 2;
        int cnt = 0;

        while (cnt < 4) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && graph[nr][nc] == 0) {
                break;
            } else {
                cnt++;
                d = (d + 1) % 4;
            }
        }

        if (cnt != 4) {
            dfs(r + dr[d], c + dc[d], (d + 1) % 4, depth + 1);

        } else {
            if (graph[r + dr[(d + 1) % 4]][c + dc[(d + 1) % 4]] == 1) {
                bw.write(depth + "\n");
            } else {
                dfs(r + dr[(d + 1) % 4], c + dc[(d + 1) % 4], d, depth);
            }
        }
    }

}