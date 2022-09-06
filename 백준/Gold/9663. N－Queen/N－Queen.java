import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static int[] col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        col = new int[n];

        dfs(0);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth) {
        if (depth == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            col[depth] = i;
            if (check(depth)) {
                dfs(depth + 1);
            }
        }
    }

    static boolean check(int depth) {
        for (int i = 0; i < depth; i++) {
            if (col[i] == col[depth] || Math.abs(col[depth] - col[i]) == depth - i) {
                return false;
            }
        }
        return true;
    }

}