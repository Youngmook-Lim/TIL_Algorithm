import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static double prob, ans;
    static int[] news_prob;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static boolean[][] visited;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        news_prob = new int[4];
        for (int i = 0; i < 4; i++) {
            news_prob[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[30][30];
        visited[15][15] = true;
        list = new ArrayList<>();

        dfs(15, 15, 0);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int y, int x, int depth) {
        if (depth == n) {
            double probability = 1;
            for (int l : list) {
                probability = probability * news_prob[l] / 100;
            }
            ans += probability;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (visited[ny][nx]) continue;

            visited[ny][nx] = true;
            list.add(i);
            dfs(ny, nx, depth + 1);
            list.remove(list.size() - 1);
            visited[ny][nx] = false;
        }
    }
}