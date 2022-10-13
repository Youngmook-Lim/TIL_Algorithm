import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 1. 멘홀로 진입 (BFS로 좌표랑 타입 P클래스로 추가)
 * 2. 4방(또는2방)탐색
 * 3. 탐색할때 nx, ny에 있는 터널이 호환 가능한지 확인 필요
 * (위는 1,2,5,6 / 아래는 1,2,4,6 / 오른쪽은 1,3,6,7 / 왼쪽은 1,3,4,5)
 * 4. BFS는 시간경과될때 또는 큐 빌때까지 진행
 * */
public class Solution {

    static int n, m, r, c, l, ans;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] dx = {{}, {1, -1, 0, 0}, {0, 0}, {1, -1}, {0, 1}, {0, 1}, {-1, 0}, {-1, 0}};
    static int[][] dy = {{}, {0, 0, 1, -1}, {-1, 1}, {0, 0}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static List<Integer>[] canEnter; // 북, 동, 남, 서

    static class P {
        int x, y, type;

        public P(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        canEnter = new List[4];

        canEnter[0] = Arrays.asList(new Integer[]{1, 2, 5, 6});
        canEnter[1] = Arrays.asList(new Integer[]{1, 3, 6, 7});
        canEnter[2] = Arrays.asList(new Integer[]{1, 2, 4, 7});
        canEnter[3] = Arrays.asList(new Integer[]{1, 3, 4, 5});


        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            ans = 1;
            graph = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs();

            sb.append("#" + t + " " + ans + '\n');

        }
        System.out.println(sb);
        br.close();
    }

    static void bfs() {
        int time = 1;
        Queue<P> q = new ArrayDeque<>();
        visited[r][c] = true;
        q.add(new P(c, r, graph[r][c]));

        while (!q.isEmpty() && time++ < l) {
            int size = q.size();
            while (size-- > 0) {
                P p = q.poll();

                if (p.type == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nx = p.x + dx[p.type][k];
                        int ny = p.y + dy[p.type][k];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[ny][nx]) continue;

                        if (!checkPossible(dx[p.type][k], dy[p.type][k], graph[ny][nx])) continue;

                        visited[ny][nx] = true;
                        ans++;
                        q.add(new P(nx, ny, graph[ny][nx]));
                    }
                } else {
                    for (int k = 0; k < 2; k++) {
                        int nx = p.x + dx[p.type][k];
                        int ny = p.y + dy[p.type][k];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[ny][nx] || graph[ny][nx] == 0) continue;

                        if (!checkPossible(dx[p.type][k], dy[p.type][k], graph[ny][nx])) continue;

                        visited[ny][nx] = true;
                        ans++;
                        q.add(new P(nx, ny, graph[ny][nx]));
                    }

                }
            }

        }

    }

    static boolean checkPossible(int xDir, int yDir, int nextTunnel) {
        if (xDir == 0 && yDir == -1) {
            if (canEnter[0].contains(nextTunnel)) {
                return true;
            }
        } else if (xDir == 1 && yDir == 0) {
            if (canEnter[1].contains(nextTunnel)) {
                return true;
            }
        } else if (xDir == 0 && yDir == 1) {
            if (canEnter[2].contains(nextTunnel)) {
                return true;
            }
        } else if (xDir == -1 && yDir == 0) {
            if (canEnter[3].contains(nextTunnel)) {
                return true;
            }
        }
        return false;
    }


}