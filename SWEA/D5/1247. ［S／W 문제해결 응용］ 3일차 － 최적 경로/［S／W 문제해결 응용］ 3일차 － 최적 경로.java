import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, ans;
    static boolean[] visited;

    static class Coords {
        int x, y;

        Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Coords[] arr;

    static Coords company, house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new Coords[n];
            visited = new boolean[n];
            ans = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            company = new Coords(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            house = new Coords(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int i = 0; i < n; i++) {
                arr[i] = new Coords(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            dfs(0, 0, 0);

            System.out.println("#" + t + " " + ans);

        }

        br.close();
    }

    static int findDistance(Coords a, Coords b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static void dfs(int depth, int prev, int dist) {
        if (dist >= ans) {
            return;
        }

        if (depth == n) {
            ans = Math.min(ans, dist + findDistance(house, arr[prev]));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (depth == 0) {
                    dfs(depth + 1, i, dist + findDistance(company, arr[i]));
                } else {
                    dfs(depth + 1, i, dist + findDistance(arr[prev], arr[i]));
                }
                visited[i] = false;
            }
        }
    }

}