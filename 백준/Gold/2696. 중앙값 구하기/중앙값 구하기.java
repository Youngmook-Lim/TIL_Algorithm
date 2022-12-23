import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, m, n;
    static int[] arr;
    static Queue<Integer> pq;
    static Queue<Integer> tmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            m = Integer.parseInt(br.readLine());
            arr = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                if (i != 0 && i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                arr[i] = Integer.parseInt(st.nextToken());
            }
            pq = new PriorityQueue<>();
            tmp = new ArrayDeque<>();

            n = m / 2 + 1;
            sb.append(n).append('\n');

            for (int i = 0; i < n; i++) {
                if (i != 0 && i % 10 == 0) {
                    sb.append('\n');
                }
                int idx = i * 2;
                pq.add(arr[idx]);
                if (idx > 0) {
                    pq.add(arr[idx - 1]);
                }
                idx /= 2;
                while (idx-- > 0) {
                    tmp.add(pq.poll());
                }
                sb.append(pq.peek()).append(' ');
                while (!tmp.isEmpty()) {
                    pq.add(tmp.poll());
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
        br.close();
    }


}
