import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, ans;
    static List<Integer>[] list;
    static int[] pop;
    static boolean[] sel, visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        pop = new int[n + 1];
        list = new ArrayList[n + 1];
        sel = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        ans = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int population = Integer.parseInt(st.nextToken());
            pop[i] = population;
        }
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int nums = Integer.parseInt(st.nextToken());
            for (int j = 0; j < nums; j++) {
                int next = Integer.parseInt(st.nextToken());
                list[i].add(next);
            }
        }

        for (int k = 1; k <= n / 2; k++) {
            divideDistricts(1, 0, k);
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }


        br.close();
    }

    static void divideDistricts(int idx, int depth, int target) {

        if (depth == target) {
            if (check()) {
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 1; i <= n; i++) {
                    if (sel[i]) {
                        sum1 += pop[i];
                    } else {
                        sum2 += pop[i];
                    }
                }
                ans = Math.min(ans, Math.abs(sum1 - sum2));
            }
//            for (int i = 1; i <= n; i++) {
//                if (sel[i]) {
//                    System.out.print(i + " ");
//                }
//            }
//            System.out.println();
            return;
        }

        for (int i = idx; i <= n; i++) {
            sel[i] = true;
            divideDistricts(i + 1, depth + 1, target);
            sel[i] = false;
        }
    }

    static boolean check() {
        visited = new boolean[n + 1];
        int idx1 = -1;
        int idx2 = -1;
        for (int i = 1, cnt = 0; i <= n || cnt < 2; i++) {
            if (sel[i] && idx1 == -1) {
                idx1 = i;
                cnt++;
            } else if (!sel[i] && idx2 == -1) {
                idx2 = i;
                cnt++;
            }
        }

        dfs(idx1, sel[idx1]);
        dfs(idx2, sel[idx2]);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int start, boolean type) {
        visited[start] = true;
        for (int i = 0; i < list[start].size(); i++) {
            int next = list[start].get(i);
            if (!visited[next] && sel[next] == type) {
                dfs(next, type);
            }
        }
    }

}

