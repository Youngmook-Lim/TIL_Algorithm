import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int r, c, ans;
    static char[][] graph;
    static boolean[][] visited;
    static boolean[] alphabet = new boolean[26];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < c; j++) {
                graph[i][j] = tmp.charAt(j);
            }
        }

        visited[0][0] = true;
        alphabet[graph[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(ans);

        br.close();
    }

    static void dfs(int x, int y, int len) {

        ans = Math.max(ans, len);

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= c || ny < 0 || ny >= r || visited[ny][nx]) continue;
            if (alphabet[graph[ny][nx] - 'A']) continue;

            visited[ny][nx] = true;
            alphabet[graph[ny][nx] - 'A'] = true;

            dfs(nx, ny, len + 1);

            alphabet[graph[ny][nx] - 'A'] = false;
            visited[ny][nx] = false;
        }


    }

}

