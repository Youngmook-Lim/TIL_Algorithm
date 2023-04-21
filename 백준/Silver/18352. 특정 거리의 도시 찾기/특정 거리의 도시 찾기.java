import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n, m, k, x;
    static List<Integer>[] adj;
    static int[] dist;
    static Queue<Integer> q;
    static List<Integer> ansList;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        adj = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
        q = new ArrayDeque<>();
        ansList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (adj[a] == null) {
                adj[a] = new ArrayList<>();
            }
            adj[a].add(b);
        }

        dist[x] = 0;
        q.add(x);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (dist[cur] == k) {
                ansList.add(cur);
            }
            if (dist[cur] > k) break;

            if (adj[cur] == null) continue;

            for (int next : adj[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }

        if (ansList.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(ansList);
            StringBuilder sb = new StringBuilder();
            for (int num : ansList) {
                sb.append(num).append('\n');
            }
            System.out.println(sb);
        }

        br.close();
    }


}
