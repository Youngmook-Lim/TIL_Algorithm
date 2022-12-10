import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static List<Integer> list;
    static int[][] bad;
    static int n, m, cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        bad = new int[n + 1][n + 1];
        list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bad[a][b] = 1;
            bad[b][a] = 1;
        }

        brute(1, 0);

        System.out.println(cnt);

        br.close();
    }

    static void brute(int idx, int depth) {
        if (depth == 3) {
            if (check()) cnt++;
            return;
        }

        for (int i = idx; i < n + 1; i++) {
            list.add(i);
            brute(i + 1, depth + 1);
            list.remove(list.size() - 1);
        }
    }

    static boolean check() {
        if (bad[list.get(0)][list.get(1)] == 1) return false;
        if (bad[list.get(2)][list.get(1)] == 1) return false;
        if (bad[list.get(0)][list.get(2)] == 1) return false;
        return true;
    }

}
