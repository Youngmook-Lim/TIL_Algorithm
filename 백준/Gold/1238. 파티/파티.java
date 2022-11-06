import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 * 1. 인접리스트 2개 만들기 (방향 반대)
 * 2. x에서 시작하는 다익스트라 각 인접리스트로 실행해서 결과값 더하기
 * */
public class Main {

    static final int INF = 987654321;
    static int n, m, x, ans;
    static boolean[] visited;
    static int[] dist, distReverse;
    static List<P>[] adj, adjReverse;

    static class P {
        int num, dist;

        public P(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        adj = new List[n + 1];
        adjReverse = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
            adjReverse[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        distReverse = new int[n + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(distReverse, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[start].add(new P(end, dist));
            adjReverse[end].add(new P(start, dist));
        }

        dijkstra(adj, dist);
        dijkstra(adjReverse, distReverse);

        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(ans, dist[i] + distReverse[i]);
        }

        System.out.println(ans);

        br.close();
    }

    static void dijkstra(List<P>[] list, int[] dist) {
        Queue<P> pq = new PriorityQueue<>(new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                return o1.dist - o2.dist;
            }
        });
        visited = new boolean[n + 1];
        dist[x] = 0;
        pq.add(new P(x, 0));
        while (!pq.isEmpty()) {
            P p = pq.poll();

            if (visited[p.num]) continue;
            visited[p.num] = true;

            for (P next : list[p.num]) {
                if (!visited[next.num] && dist[p.num] + next.dist < dist[next.num]) {
                    dist[next.num] = dist[p.num] + next.dist;
                    pq.add(new P(next.num, dist[next.num]));
                }
            }
        }

    }

}

