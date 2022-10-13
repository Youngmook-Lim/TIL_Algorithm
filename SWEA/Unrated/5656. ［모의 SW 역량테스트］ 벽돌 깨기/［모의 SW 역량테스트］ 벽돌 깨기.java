import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 1. 0~w의 n크기의 중복조합을 만들어서 각각 구현
 * 2. 구현
 *      2.1. 위에서부터 0이 아닌숫자 탐색(시작포인트) -> P 클래스 생성
 *      2.2. Queue에 넣고 BFS, 사방탐색 -> 사방탐색하다가 1 이상인거 걸리면 큐에 좌표랑 숫자 넣기
 *      2.3. 큐 빌때까지 ㄱㄱ
 *      2.4. 밑에서 시작해서 0 아닌거 밑으로 끌어내리기 (idx++ 하면서)
 * */
public class Solution {

    static int n, w, h, ans;
    static int[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> list;

    static class P {
        int x, y, power;

        public P(int x, int y, int power) {
            this.x = x;
            this.y = y;
            this.power = power;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            graph = new int[h][w];
            list = new ArrayList<>();
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0);

            sb.append("#" + t + " ").append(ans).append('\n');

        }
        System.out.println(sb);
        br.close();
    }

    static void dfs(int depth) {
        if (depth == n) {
            breakBrick();
            return;
        }
        for (int i = 0; i < w; i++) {
            list.add(i);
            dfs(depth + 1);
            list.remove(list.size() - 1);
        }
    }

    static void breakBrick() {
        int tmp[][] = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                tmp[i][j] = graph[i][j];
            }
        }

        for (int i = 0; i < n; i++) {

            int startX = list.get(i);
            int startY = 0;
            while (startY < h) {
                if (tmp[startY][startX] != 0) break;
                startY++;
            }
            if (startY == h) continue;

            Queue<P> q = new ArrayDeque<>();

            q.add(new P(startX, startY, tmp[startY][startX]));
            tmp[startY][startX] = 0;

            while (!q.isEmpty()) {
                P p = q.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    int cnt = 0;

                    while (nx >= 0 && nx < w && ny >= 0 && ny < h && cnt < p.power - 1) {
                        if (tmp[ny][nx] == 1) {
                            tmp[ny][nx] = 0;
                        } else if (tmp[ny][nx] != 0) {
                            q.add(new P(nx, ny, tmp[ny][nx]));
                            tmp[ny][nx] = 0;
                        }
                        nx += dx[k];
                        ny += dy[k];
                        cnt++;
                    }

                }
            }

            for (int j = 0; j < w; j++) {
                int idx = h - 1;
                int zeroIdx = -1;
                while (idx >= 0) {
                    if (tmp[idx][j] != 0) {
                        if (zeroIdx != -1) {
                            tmp[zeroIdx][j] = tmp[idx][j];
                            tmp[idx][j] = 0;
                            while (zeroIdx >= 0 && tmp[zeroIdx][j] != 0) {
                                zeroIdx--;
                            }
                        }
                    } else {
                        if (zeroIdx == -1) {
                            zeroIdx = idx;
                        }
                    }
                    idx--;
                }
            }

//            for (int[] x : tmp) {
//                System.out.println(Arrays.toString(x));
//            }
//            System.out.println();
        }

        int left = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (tmp[i][j] != 0) left++;
            }
        }

        ans = Math.min(ans, left);

    }


}