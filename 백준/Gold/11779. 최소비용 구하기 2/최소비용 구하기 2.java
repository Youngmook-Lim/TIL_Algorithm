import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static final int INF = 987654321;
    static int n, m, start, end;
    static boolean[] visited;
    static int[] costs;
    static List<Node>[] adj;

    static class Node {
        int v, cost;
        List<Integer> history;

        public Node(int v, int cost, List<Integer> history) {
            this.v = v;
            this.cost = cost;
            this.history = history;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", cost=" + cost +
                    ", history=" + history +
                    '}';
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
            adj[start].add(new Node(end, cost, null));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        List<Integer> ans = dijkstra(start);

        StringBuilder sb = new StringBuilder();
        sb.append(costs[end]).append('\n');
        sb.append(ans.size()).append('\n');
        for (int x : ans) {
            sb.append(x).append(' ');
        }

        System.out.println(sb);

        br.close();
    }

    static List<Integer> dijkstra(int start) {
        costs = new int[n + 1];
        Arrays.fill(costs, INF);
        costs[start] = 0;
        visited = new boolean[n + 1];
        Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        List<Integer> tmp = new ArrayList<>();
        tmp.add(start);
        pq.add(new Node(start, 0, tmp));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.v == end) {
                return cur.history;
            }

            if (visited[cur.v]) continue;
            visited[cur.v] = true;

            for (Node next : adj[cur.v]) {
                if (!visited[next.v] && costs[cur.v] + next.cost <= costs[next.v]) {
                    costs[next.v] = costs[cur.v] + next.cost;
                    tmp = new ArrayList<>(cur.history);
                    tmp.add(next.v);
                    pq.add(new Node(next.v, costs[next.v], tmp));
                }
            }

        }
        return null;
    }


}

