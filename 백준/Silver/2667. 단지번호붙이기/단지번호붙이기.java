import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> listAns;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        listAns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    listAns.add(bfs(i, j));
                }
            }
        }

        Collections.sort(listAns);

        System.out.println(listAns.size());
        for (int x : listAns) {
            System.out.println(x);
        }

        br.close();

    }

    static int bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();
        int cnt = 1;

        q.add(new Pair(x, y));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx] && map[ny][nx] != 0) {
                    q.add(new Pair(nx, ny));
                    visited[ny][nx] = true;
                    cnt++;
                }
            }

        }

        return cnt;

    }

}

