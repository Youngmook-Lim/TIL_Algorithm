import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, m, n;
    static int[] arr;
    static Queue<Integer> pqMax, pqMin;

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
            pqMax = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            pqMin = new PriorityQueue<>();

            n = m / 2 + 1;
            sb.append(n);

            for (int i = 0; i < m; i++) {
                if (i % 20 == 0) {
                    sb.append('\n');
                }
                if (pqMax.size() == pqMin.size()) {
                    pqMax.add(arr[i]);
                } else {
                    pqMin.add(arr[i]);
                }
                if (!pqMax.isEmpty() && !pqMin.isEmpty()) {
                    if (pqMax.peek() > pqMin.peek()) {
                        int max = pqMax.poll();
                        int min = pqMin.poll();
                        pqMax.add(min);
                        pqMin.add(max);
                    }
                }
                if (i % 2 == 0) {
                    sb.append(pqMax.peek()).append(' ');
                }
            }

            sb.append('\n');
        }
        System.out.println(sb);
        br.close();
    }


}
