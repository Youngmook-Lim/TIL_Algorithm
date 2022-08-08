import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] graph;

    static int min = Integer.MAX_VALUE;

    static List<Integer> list = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();

    static Set<Integer> set = new HashSet<>();

    static int getTotal(List<Integer> list) {
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                total += graph[list.get(i) - 1][list.get(j) - 1];
            }
        }
        return total;
    }

    static void dfs(int depth, int idx) {
        if (depth == n / 2) {
            Set<Integer> setTotal = new HashSet<>(set);
            Set<Integer> listSet = new HashSet<>(list);
            setTotal.removeAll(listSet);
            list2.addAll(setTotal);
            int a = getTotal(list);
            int b = getTotal(list2);
//            System.out.println(a + ", " + b);
            int x = Math.abs(a - b);
            if (x < min) {
                min = x;
            }
            list2.clear();

        }

        for (int i = idx; i <= n; i++) {
            if (i > idx && depth == 0) break;
            list.add(i);
            dfs(depth + 1, i + 1);
            list.remove(list.size() - 1);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            set.add(i + 1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1);

        System.out.println(min);

        br.close();

    }

}



