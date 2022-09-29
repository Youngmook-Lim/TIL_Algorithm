import java.io.*;
import java.util.*;

public class Solution {
    static final long INF = Long.MAX_VALUE;
    static long ans;
    static int n, pick;
    static double e;
    static int[] x, y;
    static Queue<Node> q;

    static class Node implements Comparable<Node> {
        int v;
        long dist;

        public Node(int v, long dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", dist=" + dist +
                    '}';
        }
    }

    static long[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            ans = 0;
            pick = 0;
            n = Integer.parseInt(br.readLine());
            x = new int[n];
            y = new int[n];
            visited = new boolean[n];
            dist = new long[n];
            Arrays.fill(dist, INF);
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }
            e = Double.parseDouble(br.readLine());

            q = new PriorityQueue<>();
            q.add(new Node(0, 0));

            while (pick < n) {
                Node node = q.poll();

                if (visited[node.v]) continue;
                visited[node.v] = true;
                ans += node.dist;

                for (int i = 0; i < n; i++) {
                    if (!visited[i] && i != node.v) {
                        long calculatedDist = calcDist(node.v, i);
                        if (calculatedDist < dist[i]) {
                            dist[i] = calculatedDist;
                            q.add(new Node(i, calculatedDist));
                        }
                    }
                }
                pick++;
            }

            ans = Math.round(ans * e);

            sb.append("#" + t + " " + ans + "\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static long calcDist(int a, int b) {
        return (long) (Math.pow(Math.abs(x[a] - x[b]), 2) + Math.pow(Math.abs(y[a] - y[b]), 2));
    }


}