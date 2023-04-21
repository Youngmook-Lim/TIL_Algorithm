import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n, m, k, x;
    static List<Node>[] adj;
    static boolean[] visited;
    static int[] dist;
    static Queue<Node> pq;
    static List<Integer> ansList;

    static class Node implements Comparable<Node> {
        int node, d;

        public Node(int node, int d) {
            this.node = node;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            if (this.d != o.d) {
                return this.d - o.d;
            }
            return this.node - o.node;
        }
    }

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
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq = new PriorityQueue<>();
        ansList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, 1));
        }

        dist[x] = 0;
        pq.add(new Node(x, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.node]) continue;
            visited[cur.node] = true;

            for (Node next : adj[cur.node]) {
                if (!visited[next.node] && dist[cur.node] + next.d < dist[next.node]) {
                    dist[next.node] = dist[cur.node] + next.d;
                    pq.add(new Node(next.node, dist[next.node]));
                }
            }
        }

//        System.out.println(Arrays.toString(dist));

        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == k) {
                ansList.add(i);
            }
        }

        if (ansList.isEmpty()) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int num : ansList) {
                sb.append(num).append('\n');
            }
            System.out.println(sb);
        }

        br.close();
    }


}
