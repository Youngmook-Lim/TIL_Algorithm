import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] graph;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 1);

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();
    } // main

    static void dfs(int startY, int startX, int endY, int endX) {
        if (startY >= n || startX >= n || endY >= n || endX >= n)
            return;
        if (endY == n - 1 && endX == n - 1) {
            cnt++;
            return;
        }

//        System.out.println(startY + " " + startX + " " + endY + " " + endX);
        if (startY == endY) {
            if (endX + 1 < n && graph[endY][endX + 1] != 1) {
                dfs(startY, startX + 1, endY, endX + 1);
                if (endY + 1 < n && graph[endY + 1][endX] != 1 && graph[endY + 1][endX + 1] != 1) {
                    dfs(startY, startX + 1, endY + 1, endX + 1);
                }
            }
        } else if (startX == endX) {
            if (endY + 1 < n && graph[endY + 1][endX] != 1) {
                dfs(startY + 1, startX, endY + 1, endX);
                if (endX + 1 < n && graph[endY][endX + 1] != 1 && graph[endY + 1][endX + 1] != 1) {
                    dfs(startY + 1, startX, endY + 1, endX + 1);
                }
            }
        } else {
            if (endX + 1 < n && graph[endY][endX + 1] != 1) {
                dfs(startY + 1, startX + 1, endY, endX + 1);
            }
            if (endY + 1 < n && graph[endY + 1][endX] != 1) {
                dfs(startY + 1, startX + 1, endY + 1, endX);
            }
            if (endY + 1 < n && endX + 1 < n && graph[endY][endX + 1] != 1 &&
                    graph[endY + 1][endX] != 1 && graph[endY + 1][endX + 1] != 1) {
                dfs(startY + 1, startX + 1, endY + 1, endX + 1);
            }
        }
    }


}