import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 1. 2의 위치를 저장하여 리스트에 저장, 1도 저장
 * 2. 폐업할 치킨집 (총 - m) 개수의 조합을 구함 (dfs)
 * 3. 해당 2들을 0으로 바꿔놓고, bfs를 통해 각각의 치킨거리 계산 (P : x, y, dist) / visit배열 사용
 * 4. 집 다돌고 합 구해서 ans랑 m교n 비교
 * */

public class Main {

    static int n, m, chickenNo, ans, tmpTotal;
    static int[][] graph;
    static int[][] visited;
    static List<Integer> combination;
    static List<P> chickenHouses;
    static List<P> houses;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class P {
        int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        houses = new ArrayList<>();
        chickenHouses = new ArrayList<>();
        combination = new ArrayList<>();
        chickenNo = 0;
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    houses.add(new P(j, i));
                } else if (graph[i][j] == 2) {
                    chickenHouses.add(new P(j, i));
                    chickenNo++;
                }
            }
        }

        getCombination(0, 0);
        System.out.println(ans);
        br.close();
    }

    static void getCombination(int depth, int idx) {
        if (depth == chickenNo - m) {
            destroyOrRestoreChicken(true);
            tmpTotal = 0;
            for (int i = 0; i < houses.size(); i++) {
                tmpTotal += calculate(houses.get(i));
                if (tmpTotal >= ans) break;
            }
            ans = Math.min(ans, tmpTotal);
            destroyOrRestoreChicken(false);
            return;
        }
        for (int i = idx; i < chickenNo; i++) {
            combination.add(i);
            getCombination(depth + 1, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    static int calculate(P start) {
        visited = new int[n][n];
        Queue<P> q = new ArrayDeque<>();
        q.add(start);
        visited[start.y][start.x] = 1;
        while (!q.isEmpty()) {
            P p = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[ny][nx] != 0) continue;

                if (graph[ny][nx] == 2) {
                    return visited[p.y][p.x];
                }

                visited[ny][nx] = visited[p.y][p.x] + 1;
                q.add(new P(nx, ny));
            }
        }
        return 0;
    }

    static void destroyOrRestoreChicken(boolean type) {
        for (int i = 0; i < chickenNo - m; i++) {
            P p = chickenHouses.get(combination.get(i));
            graph[p.y][p.x] = type ? 0 : 2;
        }
    }


}

