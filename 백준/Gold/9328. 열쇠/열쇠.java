import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 그래프에 테두리를 만들어서 그림 (그래야 편함)
 * 2. visit 배열을 3차원으로 만들고 그 깊이를 알파벳 수만큼 한다 (없었던 열쇠 하나 먹으면 한 칸 내려가기)
 * */
public class Main {

    static int T, h, w;
    static int depth;
    static int ans;
    static char[][] graph;
    static boolean[][][] visited;
    static boolean[] hasKey;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken()) + 2;
            w = Integer.parseInt(st.nextToken()) + 2;
            graph = new char[h][w];
            visited = new boolean[h][w][27];
            hasKey = new boolean[26];
            depth = 0;
            ans = 0;
            for (int i = 1; i < h - 1; i++) {
                String input = br.readLine();
                for (int j = 1; j < w - 1; j++) {
                    graph[i][j] = input.charAt(j - 1);
                }
            }
            String keys = br.readLine();
            for (int i = 0; i < keys.length(); i++) {
                char key = keys.charAt(i);
                if (key == '0') break;

                hasKey[key - 'a'] = true;
            }

            search(0, 0);

            sb.append(ans).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    static void search(int y, int x) {
        visited[y][x][depth] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            // OB
            if (nx < 0 || nx >= w || ny < 0 || ny >= h) continue;

            // visited
            if (visited[ny][nx][depth]) continue;

            // 벽
            if (graph[ny][nx] == '*') continue;

            // 문
            if (graph[ny][nx] - 'A' >= 0 && graph[ny][nx] - 'A' < 26) {
                if (!hasKey[graph[ny][nx] - 'A']) {
                    continue;
                }
            }

            // 열쇠
            if (graph[ny][nx] - 'a' >= 0 && graph[ny][nx] - 'a' < 26) {
                if (!hasKey[graph[ny][nx] - 'a']) {
                    hasKey[graph[ny][nx] - 'a'] = true;
                    depth++;
                }
            }

            // 문서
            if (graph[ny][nx] == '$') {
                graph[ny][nx] = '.';
                ans++;
            }

            search(ny, nx);
        }
    }

}
