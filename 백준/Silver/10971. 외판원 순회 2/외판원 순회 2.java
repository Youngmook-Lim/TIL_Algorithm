import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] graph;
    static int[][] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        memo = new int[n][1 << n];

        int solution = getMinDistance(0, 1);

        System.out.println(solution);

        br.close();
    }

    static int getMinDistance(int cur, int visited) {

        if (visited == ((1 << n) - 1)) {
            if (graph[cur][0] == 0) {
                return 987654321;
            }
            return graph[cur][0];
        }

        if (memo[cur][visited] != 0) {
            return memo[cur][visited];
        }

        memo[cur][visited] = 987654321;

        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) == 0 && graph[cur][i] != 0) {
                memo[cur][visited] = Math.min(memo[cur][visited], graph[cur][i] + getMinDistance(i, visited | (1 << i)));
            }
        }

        return memo[cur][visited];
    }


}



