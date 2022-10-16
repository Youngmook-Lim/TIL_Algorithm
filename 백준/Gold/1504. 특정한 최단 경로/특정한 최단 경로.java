import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 다익스트라 수행하나, 시작 -> v1 -> v2 -> n 이거랑 시작 -> v2 -> v1 -> n을 비교해서 작은거 출력
2. 둘다 노답이면 -1 출력
3. 각각의 스테이지마다 다익스트라 각각 수행
 */
public class Main {
    static final int INF = 987654321;
    static int n, e, v1, v2;
    static long ans1, ans2;
    static boolean[] visited;
    static int[] distance;
    static List<Node>[] adj;

    static class Node {
        int v, dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        ans1 += dijkstra(1, v1);
        ans1 += dijkstra(v1, v2);
        ans1 += dijkstra(v2, n);

        ans2 += dijkstra(1, v2);
        ans2 += dijkstra(v2, v1);
        ans2 += dijkstra(v1, n);

        if (ans1 >= INF && ans2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(ans1, ans2));
        }

        br.close();
    }

    static int dijkstra(int start, int target) {
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        distance[start] = 0;
        Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist - o2.dist;
            }
        });

        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.v]) continue;
            visited[cur.v] = true;

            if (cur.v == target) {
                return distance[cur.v];
            }

            for (Node next : adj[cur.v]) {
                if (!visited[next.v] && distance[cur.v] + next.dist < distance[next.v]) {
                    distance[next.v] = distance[cur.v] + next.dist;
                    pq.add(new Node(next.v, distance[next.v]));
                }
            }

        }
        return INF;
    }


}

