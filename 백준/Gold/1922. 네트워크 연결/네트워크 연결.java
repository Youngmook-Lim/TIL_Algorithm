import java.io.*;
import java.util.*;

public class Main {
    static int n, m, pick;
    static long ans;

    static class Edge {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static Edge[] list;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new Edge[m];
        p = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[i] = new Edge(a, b, c);
        }

        Arrays.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        for (int i = 1; i < n + 1; i++) {
            p[i] = i;
        }
        int idx = 0;
        while (pick < n - 1) {
            Edge edge = list[idx];

            int parentStart = findSet(edge.start);
            int parentEnd = findSet(edge.end);

            if (parentStart != parentEnd) {
                p[parentEnd] = parentStart;
                ans += edge.weight;
                pick++;
            }

            idx++;

        }

        bw.write(ans + "\n");


        bw.flush();
        bw.close();
        br.close();
    }

    static int findSet(int x) {
        if (x != p[x]) {
            p[x] = findSet(p[x]);
        }
        return p[x];
    }


}
