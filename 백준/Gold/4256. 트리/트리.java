import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int T;
    static int n;
    static int[] pre, in;
    static int idx;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            pre = new int[n];
            in = new int[n];
            idx = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pre[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                in[i] = Integer.parseInt(st.nextToken());
            }

            getPost(0, n - 1, 0);

            sb.append('\n');

        }

        System.out.println(sb);


        br.close();
    }

    static void getPost(int start, int end, int targetIdx) {
        if (idx >= n) return;

        int target = pre[targetIdx];
        int pos = findIdx(target);
        if (start <= pos - 1) {
            getPost(start, pos - 1, ++idx);
        }
        if (pos + 1 <= end) {
            getPost(pos + 1, end, ++idx);
        }
        sb.append(target).append(' ');
    }

    static int findIdx(int target) {
        for (int i = 0; i < n; i++) {
            if (in[i] == target) {
                return i;
            }
        }
        return -1;
    }


}
