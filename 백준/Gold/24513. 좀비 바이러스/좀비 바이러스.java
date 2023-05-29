import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int n, m;
    static int one, two, three;
    static int[][] graph;
    static boolean[][] visited;
    static Queue<P> visitedList;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<P> q;

    static class P {
        int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        one = 1;
        two = 1;
        graph = new int[n][m];
        visited = new boolean[n][m];
        visitedList = new ArrayDeque<>();
        q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1 || graph[i][j] == 2) {
                    q.add(new P(j, i));
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                P p = q.poll();
                if (graph[p.y][p.x] == 3) continue;

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (graph[ny][nx] == -1 || graph[ny][nx] == 3) continue;
                    if (graph[ny][nx] == graph[p.y][p.x]) continue;
                    if (graph[ny][nx] != 0 && !visited[ny][nx]) continue;
                    if (graph[ny][nx] != 0 && visited[ny][nx]) {
                        if (graph[ny][nx] == 1) {
                            one--;
                        } else {
                            two--;
                        }
                        graph[ny][nx] = 3;
                        three++;
                        continue;
                    }

                    graph[ny][nx] = graph[p.y][p.x];
                    if (graph[ny][nx] == 1) {
                        one++;
                    } else {
                        two++;
                    }

                    visited[ny][nx] = true;
                    visitedList.add(new P(nx, ny));
                    q.add(new P(nx, ny));
                }
            }

            while (!visitedList.isEmpty()) {
                P p = visitedList.poll();
                visited[p.y][p.x] = false;
            }

//            for (int[] a : graph) {
//                System.out.println(Arrays.toString(a));
//            }
//            System.out.println(one + " " + two + " " + three);
//
//            System.out.println();

        }

        System.out.println(one + " " + two + " " + three);

        br.close();
    }


}
