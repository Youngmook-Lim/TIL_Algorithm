import java.io.*;
import java.util.*;

public class Solution {

    static int n, k, ans;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            graph = new int[n][n];
            ans = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, graph[i][j]);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == max) {
                        cutGround(i, j);
                    }
                }
            }

            bw.write("#" + t + " " + ans + "\n");


        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void cutGround(int y, int x) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == y && j == x) continue;
                for (int l = 1; l <= k; l++) {
                    graph[i][j] -= l;
                    visited = new boolean[n][n];
                    dfs(y, x, 1);
                    graph[i][j] += l;
                }
            }
        }
    }

    static void dfs(int y, int x, int depth) {
        visited[y][x] = true;
        if (depth > ans) {
            ans = depth;
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n
                    || visited[ny][nx]) continue;

            if (graph[ny][nx] >= graph[y][x]) continue;

            visited[ny][nx] = true;
            dfs(ny, nx, depth + 1);

        }
        visited[y][x] = false;

    }

}
