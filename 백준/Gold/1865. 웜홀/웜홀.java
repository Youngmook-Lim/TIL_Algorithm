import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 987654321;
    static boolean res;
    static int TC, n, m, w;
    static List<Edge> list;
    static int[] times;

    static class Edge {
        int start, end, time;

        public Edge(int s, int e, int t) {
            this.start = s;
            this.end = e;
            this.time = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            times = new int[n];
            Arrays.fill(times, INF);
            res = false;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken()) - 1;
                int t = Integer.parseInt(st.nextToken());
                list.add(new Edge(s, e, t));
                list.add(new Edge(e, s, t));
            }
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken()) - 1;
                int t = -Integer.parseInt(st.nextToken());
                list.add(new Edge(s, e, t));
            }

//            for (int i = 0; i < n; i++) {
//                if (bellmanFord(i)) {
//                    res = true;
//                    break;
//                }
//            }
            
            res = bellmanFord(0);

            if (res) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);

        br.close();
    }

    static boolean bellmanFord(int start) {
        boolean update;
        for (int i = 0; i < n; i++) {
            update = false;
            for (int j = 0; j < list.size(); j++) {
                Edge e = list.get(j);
                if (times[e.start] + e.time < times[e.end]) {
                    times[e.end] = times[e.start] + e.time;
                    update = true;
                    if (i == n - 1) {
                        return true;
                    }
                }
            }
            if (!update) return false;
        }
        return false;
    }
}