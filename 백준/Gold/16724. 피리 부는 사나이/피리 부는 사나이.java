import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, ans;
    static char[][] graph;
    static boolean[][] visited;
    static boolean[][] counted;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        counted = new boolean[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        simulation();

        System.out.println(ans);

        br.close();
    }

    static void simulation() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!counted[i][j]) {
                    search(i, j);
                }
            }
        }
    }

    static void search(int y, int x) {
        visited[y][x] = true;

        char dir = graph[y][x];
        int dirNum = 0;
        switch (dir) {
            case 'U':
                dirNum = 0;
                break;
            case 'D':
                dirNum = 1;
                break;
            case 'L':
                dirNum = 2;
                break;
            case 'R':
                dirNum = 3;
                break;
        }

        int nx = x + dx[dirNum];
        int ny = y + dy[dirNum];

        if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[ny][nx]) {
            ans++;
        } else if (!counted[ny][nx]) {
            search(ny, nx);
        }
        counted[y][x] = true;
        visited[y][x] = false;
    }

}
