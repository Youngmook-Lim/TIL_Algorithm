import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 1. 그래프 순회하며 하나씩 핀볼 넣어보기 (4방향으로)
 * 1-2. 그래프 입력 받을때 태두리에 5로 찍기
 * 2. DFS로 구현 (x, y, dir)
 * 3. up : 0 / right : 1 / down : 2 / left : 3 => 방향변환 배열 만들기
 * 4. 부딫힐때마다 cnt++;
 * 5. 시작점 or -1 도착하면 break;
 * 6. 웜홀 위치 저장
 * */
public class Solution {

    static int n, ans, startX, startY;
    static int[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static Map<Integer, List<int[]>> wormholeMap;
    static int[][] dirConvert = {{}, {2, 3, 1, 0}, {1, 3, 0, 2}, {3, 2, 0, 1}, {2, 0, 3, 1}, {2, 3, 0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            ans = 0;
            graph = new int[n + 2][n + 2];
            wormholeMap = new HashMap<>();
            for (int i = 0; i < n + 2; i++) {
                if (i == 0 || i == n + 1) {
                    for (int j = 0; j < n + 2; j++) {
                        graph[i][j] = 5;
                    }
                } else {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < n + 2; j++) {
                        if (j == 0 || j == n + 1) {
                            graph[i][j] = 5;
                        } else {
                            graph[i][j] = Integer.parseInt(st.nextToken());
                            if (graph[i][j] > 5 && graph[i][j] <= 10) {
                                if (wormholeMap.containsKey(graph[i][j])) {
                                    List<int[]> tmp = wormholeMap.get(graph[i][j]);
                                    tmp.add(new int[]{i, j});
                                    wormholeMap.put(graph[i][j], tmp);
                                } else {
                                    List<int[]> tmp = new ArrayList<>();
                                    tmp.add(new int[]{i, j});
                                    wormholeMap.put(graph[i][j], tmp);
                                }
                            }
                        }
                    }
                }

            }

//            for (int x : wormholeMap.keySet()) {
//                for (int[] y : wormholeMap.get(x)) {
//                    System.out.println(Arrays.toString(y));
//                }
//            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (graph[i][j] == 0) {
                        startX = j;
                        startY = i;
                        for (int k = 0; k < 4; k++) {
                            play(i, j, k, 0);
                        }
                    }
                }
            }

            sb.append("#" + t + " " + ans + '\n');

        }
        System.out.println(sb);
        br.close();
    }

    static void play(int y, int x, int dir, int cnt) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (graph[ny][nx] == -1 || (nx == startX && ny == startY)) {
            ans = Math.max(ans, cnt);
            return;
        }

        if (graph[ny][nx] > 0 && graph[ny][nx] <= 5) {
            int newDir = dirConvert[graph[ny][nx]][dir];
            play(ny, nx, newDir, cnt + 1);
        } else if (graph[ny][nx] > 5 && graph[ny][nx] <= 10) {
            List<int[]> tmp = wormholeMap.get(graph[ny][nx]);
            for (int[] p : tmp) {
                if (p[0] != ny || p[1] != nx) {
                    play(p[0], p[1], dir, cnt);
                    break;
                }
            }
        } else {
            play(ny, nx, dir, cnt);
        }

    }


}