import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new List[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> ansList = new ArrayList<>();

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
