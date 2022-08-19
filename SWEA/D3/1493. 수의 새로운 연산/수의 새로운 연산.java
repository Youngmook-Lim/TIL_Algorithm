import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        final int NUM = 300;

        int[][] graph = new int[NUM][NUM];
        graph[1][1] = 1;

        for (int i = 1; i < NUM; i++) {
            int tmp = i + 1;
            int start = graph[i - 1][1] + i - 1;
            for (int j = 1; j < NUM; j++) {
                if (i == 1 & j == 1) continue;

                if (j == 1) {
                    graph[i][j] = start;
                } else {
                    graph[i][j] = graph[i][j - 1] + tmp++;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int px = 0;
            int py = 0;
            int qx = 0;
            int qy = 0;

            loop:
            for (int i = 1; i < NUM; i++) {
                for (int j = 1; j < NUM; j++) {
                    if (p == graph[i][j]) {
                        px = j;
                        py = i;
                        break loop;
                    }
                }
            }

            loop:
            for (int i = 1; i < NUM; i++) {
                for (int j = 1; j < NUM; j++) {
                    if (q == graph[i][j]) {
                        qx = j;
                        qy = i;
                        break loop;
                    }
                }
            }

            int x = px + qx;
            int y = py + qy;

            bw.write("#" + t + " " + graph[y][x] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}