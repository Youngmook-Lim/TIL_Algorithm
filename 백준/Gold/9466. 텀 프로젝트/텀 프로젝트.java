import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int n, total;
    static int[] arr, cnt;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            cnt = new int[n + 1];
            visited = new boolean[n + 1];
            total = n;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < n + 1; i++) {
                if (visited[i]) continue;
                dfs(i, 1);
            }
            sb.append(total).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    static void dfs(int start, int count) {
        if (visited[start]) return;
        if (cnt[start] != 0) {
            int diff = count - cnt[start];
            total -= diff;
            return;
        }
        cnt[start] = count;
        dfs(arr[start], count + 1);
        visited[start] = true;
    }

}
