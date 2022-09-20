import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);

        br.close();
    }

    static void dfs(int idx, int depth) {
        if (depth == 7) {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                if ((check & (1 << i)) != 0) {
                    sum += arr[i];
                }
            }
            if (sum == 100) {
                for (int i = 0; i < 9; i++) {
                    if ((check & (1 << i)) != 0) {
                        System.out.println(arr[i]);
                    }
                }
                System.exit(0);
            }
        }

        for (int i = idx; i < 9; i++) {
            check += 1 << i;
            dfs(i + 1, depth + 1);
            check -= 1 << i;
        }
    }


}