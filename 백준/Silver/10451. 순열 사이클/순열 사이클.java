import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] arr;
    static boolean[] visited;
    static int cnt;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            cnt = 0;
            flag = false;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i + 1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;
                dive(i, i);
//                System.out.println(i + " " + Arrays.toString(visited));
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    static void dive(int start, int idx) {
        if (visited[idx]) {
            if (idx == start) {
                cnt++;
                flag = true;
            }
            return;
        }
        int num = arr[idx];
        visited[idx] = true;
        dive(start, num);
        if (!flag) {
            visited[idx] = false;
        }
    }


}
