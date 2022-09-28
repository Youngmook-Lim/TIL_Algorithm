import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int v, e, pick;
    static long ans;
    static List<Node>[] list;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
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
        visited = new boolean[v + 1];
        list = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        prim(1);

        bw.write(ans + "\n");


        bw.flush();
        bw.close();
        br.close();
    }

    static void prim(int start) {
        Queue<Node> pq = new PriorityQueue<>();
        visited[start] = true;
        pq.addAll(list[start]);
        while (pick < v - 1) {
            Node curr = pq.poll();

            if (visited[curr.v]) continue;

            visited[curr.v] = true;
            ans += curr.w;
            pq.addAll(list[curr.v]);
            pick++;
        }
    }
}