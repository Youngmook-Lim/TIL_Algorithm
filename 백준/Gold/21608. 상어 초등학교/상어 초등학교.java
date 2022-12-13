import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n, ans;
    static Queue<P> pq;
    static Map<Integer, List<Integer>> map;
    static int[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class P implements Comparable<P> {
        int adj, empty, x, y;

        public P(int adj, int empty, int x, int y) {
            this.adj = adj;
            this.empty = empty;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(P o) {
            if (this.adj != o.adj) {
                return o.adj - this.adj;
            }
            if (this.empty != o.empty) {
                return o.empty - this.empty;
            }
            if (this.y != o.y) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        map = new LinkedHashMap<>();
        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            map.put(num, list);
        }

        simulate();

        System.out.println(ans);

        br.close();
    }

    static void simulate() {
        setPosition();
        calculate();
    }

    static void calculate() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (map.get(graph[i][j]).contains(graph[ny][nx])) cnt++;
                }
                if (cnt != 0) {
                    ans += Math.pow(10, cnt - 1);
                }
            }
        }
    }

    static void setPosition() {
        for (int x : map.keySet()) {
            P p = getBestPosition(x);
            graph[p.y][p.x] = x;
        }
    }

    static P getBestPosition(int student) {
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != 0) continue;
                int[] favAndEmpty = cntFavAndEmpty(student, j, i);
                pq.add(new P(favAndEmpty[0], favAndEmpty[1], j, i));
            }
        }
        return pq.poll();
    }

    static int[] cntFavAndEmpty(int student, int x, int y) {
        int adj = 0;
        int empty = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (graph[ny][nx] == 0) {
                empty++;
                continue;
            }
            if (map.get(student).contains(graph[ny][nx])) {
                adj++;
            }
        }
        return new int[]{adj, empty};
    }

}
