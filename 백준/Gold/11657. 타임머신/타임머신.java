import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int start, end, time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int n, m;
    static long[] times;
    static List<Edge> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        times = new long[n];
        Arrays.fill(times, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());
            list.add(new Edge(s, e, t));
        }

        boolean result = bellmanFord(0);

        if (result) {
            for (int i = 1; i < n; i++) {
                if (times[i] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(times[i]);
                }
            }
        } else {
            System.out.println(-1);
        }

        br.close();
    }

    static boolean bellmanFord(int start) {
        times[start] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge e = list.get(j);
                if (times[e.start] != INF && times[e.start] + e.time < times[e.end]) {
                    times[e.end] = times[e.start] + e.time;
                    if (i == n - 1) return false;
                }
            }
        }
        return true;
    }


}

