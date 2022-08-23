import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[][] field;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int total;

    static void bfs(int i, int j) {
        visited[i][j] = true;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{i, j, 0});

        while (!q.isEmpty()) {
            Integer[] tmp = q.poll();
            int x = tmp[1];
            int y = tmp[0];
            int depth = tmp[2];
            
            total += field[y][x];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx] && depth < N / 2) {
                    visited[ny][nx] = true;
                    q.add(new Integer[]{ny, nx, depth + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            field = new int[N][N];
            visited = new boolean[N][N];
            total = 0;

            for (int i = 0; i < N; i++) {
                String[] arr = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    field[i][j] = Integer.parseInt(arr[j]);
                }
            }

            bfs(N / 2, N / 2);

            bw.write("#" + t + " " + total + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}