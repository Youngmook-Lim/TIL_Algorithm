import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static int n, m, chickenNo, ans, tmpTotal;
    static int[][] graph;
    static int[][] visited;
    static List<P> combination;
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
        if (depth == m) {
            tmpTotal = 0;
            for (int i = 0; i < houses.size(); i++) {
                P house = houses.get(i);
                int minDist = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    P chickenHouse = combination.get(j);
                    minDist = Math.min(minDist, Math.abs(house.x - chickenHouse.x) +
                            Math.abs(house.y - chickenHouse.y));
                }
                tmpTotal += minDist;
                if (tmpTotal >= ans) break;
            }
            ans = Math.min(ans, tmpTotal);
            return;
        }
        for (int i = idx; i < chickenNo; i++) {
            combination.add(chickenHouses.get(i));
            getCombination(depth + 1, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

}

