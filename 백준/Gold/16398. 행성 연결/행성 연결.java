import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static boolean[] visited;
    static List<Node>[] adj;
    static int pick;
    static long sum;

    static class Node implements Comparable<Node> {
        int node, cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i >= j) continue;
                adj[i].add(new Node(j, cost));
                adj[j].add(new Node(i, cost));
            }
        }

        prim();

        System.out.println(sum);

        br.close();
    }

    static void prim() {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.node]) continue;
            visited[cur.node] = true;
            pick++;
            sum += cur.cost;
            if (pick == n) break;
            for (Node next : adj[cur.node]) {
                if (!visited[next.node]) {
                    pq.add(next);
                }
            }

        }

    }


}
