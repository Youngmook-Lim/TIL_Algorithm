import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, max, min;
    static int[] arr;
    static int[] op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        op = new int[4];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);

        bw.write(max + "\n");
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int result) {
        if (depth == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;
            switch (i) {
                case 0:
                    result += arr[depth];
                    op[i]--;
                    dfs(depth + 1, result);
                    op[i]++;
                    result -= arr[depth];
                    break;
                case 1:
                    result -= arr[depth];
                    op[i]--;
                    dfs(depth + 1, result);
                    op[i]++;
                    result += arr[depth];
                    break;
                case 2:
                    result *= arr[depth];
                    op[i]--;
                    dfs(depth + 1, result);
                    op[i]++;
                    result /= arr[depth];
                    break;
                case 3:
                    result /= arr[depth];
                    op[i]--;
                    dfs(depth + 1, result);
                    op[i]++;
                    result *= arr[depth];
                    break;
            }
        }
    }


}