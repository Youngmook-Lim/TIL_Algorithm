import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k, ans;
    static int[] small, big;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        small = new int[n];
        big = new int[n];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            small[i] = Integer.parseInt(st.nextToken());
            big[i] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());

        dfs(0, 0, false);

        System.out.println(ans);

        br.close();
    }

    static void dfs(int idx, int sum, boolean hasUsed) {
        if (idx == n - 1) {
            ans = Math.min(ans, sum);
            return;
        }

        if (idx >= n) return;

        dfs(idx + 1, sum + small[idx], hasUsed);
        dfs(idx + 2, sum + big[idx], hasUsed);

        if (!hasUsed) {
            dfs(idx + 3, sum + k, true);
        }
    }

}

