import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new boolean[n][n];

        dfs(0);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth) {
        if (depth == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(depth, i)) {
                graph[depth][i] = true;
                dfs(depth + 1);
                graph[depth][i] = false;
            }
        }
    }

    static boolean check(int depth, int i) {
        for (int j = 0; j < depth; j++) {
            int x_pos_1 = i - (depth - j);
            int x_pos_2 = i + (depth - j);

            if (graph[j][i]
                    || (x_pos_1 >= 0 && x_pos_1 < n && graph[j][x_pos_1])
                    || (x_pos_2 >= 0 && x_pos_2 < n && graph[j][x_pos_2])) {
                return false;
            }
        }
        return true;
    }

}