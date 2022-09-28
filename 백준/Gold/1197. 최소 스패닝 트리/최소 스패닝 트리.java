import java.io.*;
import java.util.*;
 
public class Main {
 
    static int v, e, pick;
    static long ans;
    static Edge[] list;
    static int[] p;
 
    static class Edge implements Comparable<Edge> {
        int start, end, length;
 
        public Edge(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
 
        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", length=" + length +
                    '}';
        }
 
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.length, o.length);
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        ans = 0;
        pick = 0;
        p = new int[v + 1];
        list = new Edge[e];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[i] = new Edge(a, b, c);
        }

        Arrays.sort(list);

        kruskal();

        bw.write(ans + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
 
    static void kruskal() {
        for (int i = 0; i < v + 1; i++) {
            p[i] = i;
        }
 
        for (int i = 0; i < e; i++) {
            Edge edge = list[i];
            int rootStart = findSet(edge.start);
            int rootEnd = findSet(edge.end);
 
            if (rootStart != rootEnd) {
                union(rootStart, rootEnd);
                ans += edge.length;
                pick++;
            }
 
            if (pick == v - 1) {
                break;
            }
 
        }
 
    }
 
    static void union(int x, int y) {
        p[y] = x;
    }
 
    static int findSet(int x) {
        if (p[x] != x) {
            p[x] = findSet(p[x]);
        }
        return p[x];
    }
 
 
}