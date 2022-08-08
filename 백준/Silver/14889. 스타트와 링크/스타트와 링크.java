import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] graph;

    static int min = Integer.MAX_VALUE;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);

        br.close();

    }

    static void dfs(int depth, int idx) {
        if (depth == n / 2) {
            diff();
        }

        for (int i = idx; i < n; i++) {
            if (i > idx && depth == 0) break;
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    start += graph[i][j];
                    start += graph[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += graph[i][j];
                    link += graph[j][i];
                }
            }
        }
        int value = Math.abs(start - link);

        if (value < min) {
            min = value;
        }

    }

}



