import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 1. 현재 아기상어 위치에서 BFS 돌고 하나 먹으면 :
 *   a. 몇마리 먹었는지 갱신
 *   b. 크기랑 같은 수 먹었으면 크기 키워주기
 *   c. 시간 더해주기
 *   d. 여기서부터 다시 BFS
 * 2. 이번 BFS에서 못먹었다 하면 아까 시간이 정답
 * */
public class Main {

    static int n, startX, startY, t, curSize, curAte;
    static Queue<P> q;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};

    static class P {
        int x, y, t;

        public P(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 9) {
                    startX = j;
                    startY = i;
                }
            }
        }
        curSize = 2;

        while (true) {
            P p = BFS(startX, startY);
            if (p == null) {
                break;
            }

            t += p.t;
            curAte++;
            if (curAte == curSize) {
                curSize++;
                curAte = 0;
            }

            graph[p.y][p.x] = 9;
            graph[startY][startX] = 0;
            startX = p.x;
            startY = p.y;
        }

        System.out.println(t);

        br.close();
    }

    static P BFS(int x, int y) {
        q = new ArrayDeque<>();
        q.add(new P(x, y, 0));
        visited = new boolean[n][n];
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            Queue<P> tmp = new PriorityQueue<>(new Comparator<P>() {
                @Override
                public int compare(P o1, P o2) {
                    if (o1.y != o2.y) {
                        return o1.y - o2.y;
                    }
                    return o1.x - o2.x;
                }
            });

            for (int i = 0; i < size; i++) {
                P p = q.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[ny][nx]) continue;
                    if (graph[ny][nx] > curSize) continue;

                    visited[ny][nx] = true;
                    q.add(new P(nx, ny, p.t + 1));
                    if (graph[ny][nx] != 0 && graph[ny][nx] != curSize) {
                        tmp.add(new P(nx, ny, p.t + 1));
                    }

                }
            }

            if (!tmp.isEmpty()) {
                return tmp.poll();
            }

        }
        return null;
    }

}

