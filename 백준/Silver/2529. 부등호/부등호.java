import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static long max, min;
    static int k;
    static char[] arr;
    static boolean[] visited;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        arr = new char[k];
        visited = new boolean[10];
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        dfs(0);

        System.out.printf(String.format("%%0%dd", k + 1), max);
        System.out.println();
        System.out.printf(String.format("%%0%dd", k + 1), min);

        br.close();
    }

    static void calculate() {
        StringBuilder sb = new StringBuilder();
        for (int x : list) {
            sb.append(x);
        }
        long tmp = Long.parseLong(sb.toString());
        max = Math.max(max, tmp);
        min = Math.min(min, tmp);
    }

    static void dfs(int depth) {
        if (depth == k + 1) {
            calculate();
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            boolean result = false;
            if (depth != 0) {
                char symbol = arr[depth - 1];
                if (symbol == '>') {
                    result = list.get(depth - 1) > i;
                } else {
                    result = list.get(depth - 1) < i;
                }
            }

            if (depth == 0 || result) {
                list.add(i);
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }


}
