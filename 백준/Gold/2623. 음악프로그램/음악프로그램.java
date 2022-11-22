import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static boolean flag;
    static int[][] adj;
    static int[] insertCnt;
    static Queue<Integer> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new int[n + 1][n + 1];
        insertCnt = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int prev = 0;
            for (int j = 0; j < k; j++) {
                int next = Integer.parseInt(st.nextToken());
                if (prev != 0) {
                    if (adj[prev][next] == 0) {
                        adj[prev][next] = 1;
                        insertCnt[next]++;
                    }
                }
                prev = next;
            }
        }
        q = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if (insertCnt[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append('\n');

            for (int i = 1; i < n + 1; i++) {
                if (adj[cur][i] == 1) {
                    insertCnt[i]--;
                    if (insertCnt[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (insertCnt[i] != 0) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }


        br.close();

    }


}