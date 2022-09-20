import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] ans;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        ans = new int[n + 1];
        max = 0;
        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            dfs(i);
        }

        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, ans[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n + 1; i++) {
            if (ans[i] == max) {
                sb.append(i + " ");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start) {
        visited[start] = true;

        for (int x : list[start]) {
            if (!visited[x]) {
                ans[x]++;
                dfs(x);
            }
        }
    }

}