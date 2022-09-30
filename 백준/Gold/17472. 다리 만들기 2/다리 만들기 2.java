import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, vertex, ans, pick;
    static int[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Edge> list;
    static int[] p;

    static class P {
        int x, y;

        public P(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int start, end, len;

        public Edge(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.len, o.len);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", len=" + len +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        vertex = 2;
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS로 섬 마킹
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    bfs(i, j);
                    vertex++;
                }
            }
        }

        // 다리연결
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] != 0) {
                    makeBridge(i, j);
                }
            }
        }

//        for (int[] x : graph) {
//            System.out.println(Arrays.toString(x));
//        }
//        for (Edge e : list) {
//            System.out.println(e);
//        }

        // KRUSKAL
        kruskal();

        // 답
        System.out.println(ans);

        br.close();
    }

    static void kruskal() {
        vertex -= 2;
        p = new int[vertex];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);

            int rootSt = findSet(e.start);
            int rootEd = findSet(e.end);

            if (rootSt != rootEd) {
                p[rootEd] = rootSt;
                ans += e.len;
                pick++;
            }

            if (pick == vertex - 1) {
                break;
            }
        }

        if (pick < vertex - 1) {
            ans = -1;
        }
    }

    static int findSet(int x) {
        if (x != p[x]) {
            p[x] = findSet(p[x]);
        }
        return p[x];
    }

    static void makeBridge(int y, int x) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            int length = 0;
            boolean found = false;

            while (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (graph[ny][nx] == 0) {
                    length++;
                } else {
                    found = true;
                    break;
                }

                nx += dx[k];
                ny += dy[k];
            }

            if (found && length > 1) {
                list.add(new Edge(graph[y][x] - 2, graph[ny][nx] - 2, length));
            }
        }
    }

    static void bfs(int i, int j) {
        Queue<P> q = new LinkedList<>();
        q.add(new P(i, j));
        graph[i][j] = vertex;
        while (!q.isEmpty()) {
            P p = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m || graph[ny][nx] != 1) continue;

                graph[ny][nx] = vertex;
                q.add(new P(ny, nx));
            }
        }
    }


}