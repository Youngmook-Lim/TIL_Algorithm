import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k, ans;
    static int[][] graph;
    static int[][] turns;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        turns = new int[k][3];
        list = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                turns[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(ans);

        br.close();
    }

    static void dfs(int depth, int visited) {
        if (depth == k) {
            doTurns();
            return;
        }

        for (int i = 0; i < k; i++) {
            if ((visited & (1 << i)) != 0) continue;
            list.add(i);
            dfs(depth + 1, visited | (1 << i));
            list.remove(list.size() - 1);
        }
    }

    static void doTurns() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = graph[i][j];
            }
        }

        for (int x : list) {
            doTurn(x, tmp);
        }


        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = 0; j < m; j++) {
                total += tmp[i][j];
            }
            min = Math.min(min, total);
        }

        ans = Math.min(ans, min);

    }

    static void doTurn(int idx, int[][] tmpGraph) {
        int r = turns[idx][0] - 1;
        int c = turns[idx][1] - 1;
        int s = turns[idx][2];

        while (s > 0) {
            int rIdx = r - s;
            int cIdx = c - s;
            int first = tmpGraph[rIdx][cIdx];

            while (rIdx < r + s) {
                tmpGraph[rIdx][cIdx] = tmpGraph[++rIdx][cIdx];
            }
            while (cIdx < c + s) {
                tmpGraph[rIdx][cIdx] = tmpGraph[rIdx][++cIdx];
            }
            while (rIdx > r - s) {
                tmpGraph[rIdx][cIdx] = tmpGraph[--rIdx][cIdx];
            }
            while (cIdx > c - s + 1) {
                tmpGraph[rIdx][cIdx] = tmpGraph[rIdx][--cIdx];
            }
            tmpGraph[rIdx][cIdx] = first;
            s--;
        }

    }


}

