import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n, pick;
    static double ans;
    static Star[] stars;
    static double[][] adj;
    static boolean[] visited;
    static Queue<Node> pq;

    static class Star {
        double x, y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node implements Comparable<Node> {
        int num;
        double dist;

        public Node(int num, double dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        stars = new Star[n];
        adj = new double[n][n];
        visited = new boolean[n];
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Star(x, y);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (adj[i][j] == 0) {
                    double dist = getDist(stars[i], stars[j]);
                    adj[i][j] = dist;
                    adj[j][i] = dist;
                }
            }
        }

        pq.add(new Node(0, 0));

        while (pick < n) {
            Node cur = pq.poll();

            if (visited[cur.num]) continue;
            visited[cur.num] = true;

            pick++;
            ans += cur.dist;

            for (int i = 0; i < n; i++) {
                int nextNum = i;
                double nextDist = adj[cur.num][i];
                if (nextDist == 0) continue;
                if (!visited[nextNum]) {
                    pq.add(new Node(nextNum, nextDist));
                }
            }
        }

        System.out.printf("%.2f%n", ans);

        br.close();

    }

    static double getDist(Star a, Star b) {
        return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
    }


}