import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<Integer> list;
    static int[] dwarves;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dwarves = new int[9];
        list = new ArrayList<>();
        flag = false;

        for (int i = 0; i < 9; i++) {
            dwarves[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(dwarves);

        dfs(0);

        br.close();

    }

    static void dfs(int depth) {
        if (flag) return;

        if (depth == 7) {
            int sum = 0;
            for (int x : list) {
                sum += dwarves[x];
            }
            if (sum == 100) {
                for (int x : list) {
                    System.out.println(dwarves[x]);
                }
                flag = true;
            }
            return;

        }

        for (int i = depth; i < 9; i++) {
            list.add(i);
            dfs(depth + 1);
            list.remove(list.size() - 1);
        }
    }
}