import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m, ans;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static List<CC> list;
    static List<CC> tmp;

    static class CC {
        int x, y, type, dir;

        public CC(int x, int y, int type, int dir) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.dir = dir;
        }

        public void setDir(int dir) {
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        list = new ArrayList<>();
        tmp = new ArrayList<>();

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] > 0 && graph[i][j] < 6) {
                    list.add(new CC(j, i, graph[i][j], 0));
                }
            }
        }

        dfs(0);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth) {

        if (depth == list.size()) {
            visited = new boolean[n][m];
            for (int i = 0; i < depth; i++) {
                CC cur = tmp.get(i);
                visited[cur.y][cur.x] = true;
                switch (cur.type) {
                    case 1:
                        for (int k = 0; k < 1; k++) {
                            int nx = cur.x + dx[cur.dir];
                            int ny = cur.y + dy[cur.dir];

                            while (nx >= 0 && nx < m && ny >= 0 && ny < n && graph[ny][nx] != 6) {
                                visited[ny][nx] = true;
                                nx += dx[cur.dir];
                                ny += dy[cur.dir];
                            }
                        }
                        break;
                    case 2:
                        for (int k = 0; k < 2; k++) {
                            int nx = cur.x + dx[cur.dir + k * 2];
                            int ny = cur.y + dy[cur.dir + k * 2];

                            while (nx >= 0 && nx < m && ny >= 0 && ny < n && graph[ny][nx] != 6) {
                                visited[ny][nx] = true;
                                nx += dx[cur.dir + k * 2];
                                ny += dy[cur.dir + k * 2];
                            }
                        }
                        break;
                    case 3:
                        for (int k = 0; k < 2; k++) {
                            int nx = cur.x + dx[(cur.dir + k) % 4];
                            int ny = cur.y + dy[(cur.dir + k) % 4];

                            while (nx >= 0 && nx < m && ny >= 0 && ny < n && graph[ny][nx] != 6) {
                                visited[ny][nx] = true;
                                nx += dx[(cur.dir + k) % 4];
                                ny += dy[(cur.dir + k) % 4];
                            }
                        }
                        break;
                    case 4:
                        for (int k = 0; k < 3; k++) {
                            int nx = cur.x + dx[(cur.dir + k) % 4];
                            int ny = cur.y + dy[(cur.dir + k) % 4];

                            while (nx >= 0 && nx < m && ny >= 0 && ny < n && graph[ny][nx] != 6) {
                                visited[ny][nx] = true;
                                nx += dx[(cur.dir + k) % 4];
                                ny += dy[(cur.dir + k) % 4];
                            }
                        }
                        break;
                    case 5:
                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[(cur.dir + k) % 4];
                            int ny = cur.y + dy[(cur.dir + k) % 4];

                            while (nx >= 0 && nx < m && ny >= 0 && ny < n && graph[ny][nx] != 6) {
                                visited[ny][nx] = true;
                                nx += dx[(cur.dir + k) % 4];
                                ny += dy[(cur.dir + k) % 4];
                            }
                        }
                        break;
                }
            }
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (!visited[j][k] && graph[j][k] != 6) {
                        cnt++;
                    }
                }
            }
            ans = Math.min(ans, cnt);
            return;
        }

        if (list.get(depth).type == 5) {
            tmp.add(list.get(depth));
            dfs(depth + 1);
            tmp.remove(tmp.size() - 1);
        } else if (list.get(depth).type == 2) {
            for (int i = 0; i < 2; i++) {
                list.get(depth).setDir(i);
                tmp.add(list.get(depth));
                dfs(depth + 1);
                tmp.remove(tmp.size() - 1);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                list.get(depth).setDir(i);
                tmp.add(list.get(depth));
                dfs(depth + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

}