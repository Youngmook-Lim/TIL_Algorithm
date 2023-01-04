import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static int[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[101][101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            drawDragon(x, y, d, g);
        }

        getSquares();

        System.out.println(ans);

        br.close();
    }

    static void getSquares() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (graph[i][j] == 1 && graph[i + 1][j] == 1 && graph[i][j + 1] == 1 && graph[i + 1][j + 1] == 1)
                    ans++;
            }
        }
    }

    static void drawDragon(int x, int y, int d, int g) {
        graph[y][x] = 1;
        int curX = x;
        int curY = y;

        List<Integer> dirs = new ArrayList<>();
        for (int i = 0; i < g + 1; i++) {
            if (i == 0) {
                curX += dx[d];
                curY += dy[d];
                graph[curY][curX] = 1;
                dirs.add(d);
            } else {
                for (int j = dirs.size() - 1; j >= 0; j--) {
                    int newDir = (dirs.get(j) + 1) % 4;
                    curX += dx[newDir];
                    curY += dy[newDir];
                    graph[curY][curX] = 1;
                    dirs.add(newDir);
                }
            }

        }


    }


}

