import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k, ans;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static class Fireball {
        int x, y, d, s, m;

        public Fireball(int x, int y, int d, int s, int m) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;
            this.m = m;
        }
    }

    static class Space {
        int mTotal, sTotal, totalNum, d;
        boolean isEven, isOdd;

        public Space(int mTotal, int sTotal, int totalNum, boolean isEven, boolean isOdd, int d) {
            this.mTotal = mTotal;
            this.sTotal = sTotal;
            this.totalNum = totalNum;
            this.isEven = isEven;
            this.isOdd = isOdd;
            this.d = d;
        }


    }

    static class P {
        int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Fireball> listOfFireballs;
    static Queue<P> listOfSpaces;
    static Space[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        listOfFireballs = new ArrayDeque<>();
        listOfSpaces = new ArrayDeque<>();
        graph = new Space[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Fireball fireball = new Fireball(c - 1, r - 1, d, s, m);
            listOfFireballs.add(fireball);
        }

        while (k-- > 0) {
            simulation();
        }

        while (!listOfFireballs.isEmpty()) {
            ans += listOfFireballs.poll().m;
        }

        System.out.println(ans);

        br.close();
    }

    static void simulation() {
        moveFireballs();
        divideFireballs();
    }

    static void divideFireballs() {
        while (!listOfSpaces.isEmpty()) {
            P p = listOfSpaces.poll();
            Space space = graph[p.y][p.x];
            if (space.totalNum < 2) {
                listOfFireballs.add(new Fireball(p.x, p.y, space.d, space.sTotal, space.mTotal));
                graph[p.y][p.x] = null;
                continue;
            }
            int newM = space.mTotal / 5;
            if (newM == 0) {
                graph[p.y][p.x] = null;
                continue;
            }

            int newS = space.sTotal / space.totalNum;

            if (space.isEven || space.isOdd) {
                for (int i = 0; i < 4; i++) {
                    listOfFireballs.add(new Fireball(p.x, p.y, i * 2, newS, newM));
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    listOfFireballs.add(new Fireball(p.x, p.y, i * 2 + 1, newS, newM));
                }
            }
            graph[p.y][p.x] = null;

        }
    }

    static void moveFireballs() {
        while (!listOfFireballs.isEmpty()) {
            Fireball f = listOfFireballs.poll();
            int nx = f.x + dx[f.d] * f.s;
            if (nx >= 0) {
                nx = nx % n;
            } else {
                nx = (n - (-nx % n)) % n;
            }

            int ny = f.y + dy[f.d] * f.s;
            if (ny >= 0) {
                ny = ny % n;
            } else {
                ny = (n - (-ny % n)) % n;
            }

            if (graph[ny][nx] == null) {
                graph[ny][nx] = new Space(f.m, f.s, 1, f.d % 2 == 0, f.d % 2 != 0, f.d);
                listOfSpaces.add(new P(nx, ny));
            } else {
                Space cur = graph[ny][nx];
                cur.mTotal += f.m;
                cur.sTotal += f.s;
                cur.totalNum++;
                if (f.d % 2 == 0) {
                    cur.isOdd = false;
                } else {
                    cur.isEven = false;
                }
            }
        }
    }


}
