import java.io.*;
import java.util.*;

public class Main {

    static int v, e, k;
    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] map;
    static int[] distance;

    static class Node {
        int num, dist;

        Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", dist=" + dist +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        map = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            map[i] = new ArrayList<>();
        }
        distance = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            distance[i] = INF;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Node tmp = new Node(v, w);
            map[u].add(tmp);
        }

        dijkstra(k);

        for (int i = 1; i < v + 1; i++) {
            if (distance[i] == INF) {
                bw.write("INF" + "\n");
            } else {
                bw.write(distance[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int start) {
        distance[start] = 0;
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        q.add(new int[]{distance[start], start});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int d = tmp[0];
            int s = tmp[1];

            if (distance[s] < d) {
                continue;
            }

            for (Node nd : map[s]) {
                int totalDist = d + nd.dist;
                if (totalDist < distance[nd.num]) {
                    distance[nd.num] = totalDist;
                    q.add(new int[]{distance[nd.num], nd.num});
                }
            }
        }

    }

}

