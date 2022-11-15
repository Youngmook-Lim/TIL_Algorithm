import java.util.*;
import java.io.*;

class Main {

    static int n, m, t;
    static int[] order, inDegree;
    static Queue<Integer> q;
    static int[][] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<>();
        t = 1;
        adj = new int[n + 1][n + 1];
        order = new int[n + 1];
        inDegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            inDegree[to]++;
            adj[from][to] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int cur = q.poll();
                order[cur] = t;
                for (int i = 1; i < n + 1; i++) {
                    int num = adj[cur][i];
                    if (num == 0) continue;
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
            t++;
        }

        for (int i = 1; i < n + 1; i++) {
            sb.append(order[i]).append(' ');
        }
        System.out.println(sb);

        br.close();

    }


}