import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * Prim 알고리즘을 활용하여 MST 찾고, 가장 긴 간선 빼면 될듯?
 * */
public class Main {

    static int n, m, pick, ans;
    static List<N>[] adj;
    static boolean[] visited;
    static int[] dist;
    static TreeSet<Integer> ts;

    static class N {
        int v, dist;

        public N(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "N{" +
                    "v=" + v +
                    ", dist=" + dist +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new N(b, c));
            adj[b].add(new N(a, c));
        }
        visited = new boolean[n + 1];
        ts = new TreeSet<>();

        prim(1);

        System.out.println(ans - ts.last());

        br.close();
    }

    static void prim(int start) {
        Queue<N> pq = new PriorityQueue<>(new Comparator<N>() {
            @Override
            public int compare(N o1, N o2) {
                return o1.dist - o2.dist;
            }
        });
        pq.add(new N(start, 0));
        while (pick < n) {
            N cur = pq.poll();

            if (visited[cur.v]) continue;
            visited[cur.v] = true;
//            System.out.println(cur);

            ans += cur.dist;
            ts.add(cur.dist);
            pick++;

            for (N next : adj[cur.v]) {
                if (!visited[next.v]) {
                    pq.add(next);
                }
            }
        }

    }


}

