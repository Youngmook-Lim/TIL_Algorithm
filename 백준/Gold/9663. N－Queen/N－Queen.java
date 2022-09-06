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
//            for (boolean[] x : graph) {
//                System.out.println(Arrays.toString(x));
//            }
//            System.out.println();
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < depth; j++) {
                if (graph[j][i]) {
                    flag = false;
                    break;
                }
                int x_pos_1 = i - (depth - j);
                int x_pos_2 = i + (depth - j);
                if (x_pos_1 >= 0 && x_pos_1 < n && graph[j][x_pos_1]) {
                    flag = false;
                    break;
                }
                if (x_pos_2 >= 0 && x_pos_2 < n && graph[j][x_pos_2]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                graph[depth][i] = true;
                dfs(depth + 1);
                graph[depth][i] = false;
            }
        }
    }

}