import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static final int INF = 987654321;
    static int n, m, start, end;
    static boolean[] visited;
    static int[] costs, path;
    static List<Node>[] adj;
    static Deque<Integer> ans;

    static class Node {
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adj = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        getPath(end);


        StringBuilder sb = new StringBuilder();
        sb.append(costs[end]).append('\n');
        sb.append(ans.size()).append('\n');
        for (int x : ans) {
            sb.append(x).append(' ');
        }

        System.out.println(sb);

        br.close();
    }

    static void getPath(int cur) {
        ans = new ArrayDeque<>();
        while (cur != -1) {
            ans.addFirst(cur);
            cur = path[cur];
        }
    }

    static void dijkstra(int start) {
        path = new int[n + 1];
        path[start] = -1;
        costs = new int[n + 1];
        Arrays.fill(costs, INF);
        costs[start] = 0;
        Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.v == end) {
                return;
            }

            if (cur.cost > costs[cur.v]) continue;

            for (Node next : adj[cur.v]) {
                if (costs[cur.v] + next.cost < costs[next.v]) {
                    costs[next.v] = costs[cur.v] + next.cost;
                    path[next.v] = cur.v;
                    pq.add(new Node(next.v, costs[next.v]));
                }
            }

        }
    }


}

