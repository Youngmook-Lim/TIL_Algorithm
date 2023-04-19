import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static List<Edge> list;
    static int[] p;
    static int pick;
    static long sum;

    static class Edge implements Comparable<Edge> {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        p = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i >= j) continue;
                Edge edge = new Edge(i, j, cost);
                list.add(edge);
            }
        }

        Collections.sort(list);

        kruskal();

        System.out.println(sum);

        br.close();
    }

    public static void kruskal() {
        makeSet();
        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);
            int startParent = findSet(edge.start);
            int endParent = findSet(edge.end);

            if (startParent != endParent) {
                union(startParent, endParent);
                sum += edge.cost;
                pick++;
            }

            if (pick == n - 1) {
                break;
            }

        }
    }

    public static void union(int x, int y) {
        p[x] = y;
    }

    public static int findSet(int x) {
        if (p[x] != x) {
            p[x] = findSet(p[x]);
        }
        return p[x];
    }

    public static void makeSet() {
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
    }

}
