import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m, ans;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) {
                    int total = 0;
                    for (int l = 0; l < n; l++) {
                        total += Math.max(Math.max(graph[l][i], graph[l][j]), graph[l][k]);
                    }
                    ans = Math.max(ans, total);
                }
            }
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }


}