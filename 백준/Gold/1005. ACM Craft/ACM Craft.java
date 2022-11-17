import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int T, n, k, target, ans;
    static List<Integer>[] adj;
    static int[] incoming, time, max;
    static Queue<int[]> q;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            ans = 0;
            adj = new List[n + 1];
            for (int i = 1; i < n + 1; i++) {
                adj[i] = new ArrayList<>();
            }
            incoming = new int[n + 1];
            time = new int[n + 1];
            max = new int[n + 1];
            q = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                max[i] = time[i];
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                adj[x].add(y);
                incoming[y]++;
            }
            target = Integer.parseInt(br.readLine());

            for (int i = 1; i < n + 1; i++) {
                if (incoming[i] == 0) {
                    q.add(new int[]{i, time[i]});
                }
            }

            while (!q.isEmpty()) {
                int[] p = q.poll();
                int node = p[0];
                int nodeTime = p[1];

                if (node == target) {
                    ans = Math.max(ans, max[node]);
                    continue;
                }

                for (int x : adj[node]) {
                    incoming[x]--;
                    max[x] = Math.max(max[x], nodeTime + time[x]);

                    if (incoming[x] == 0) {
                        q.add(new int[]{x, max[x]});
                    }
                }
            }
            sb.append(ans).append('\n');
        }

        System.out.println(sb);

        br.close();

    }


}