import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k;
    static int[] arr;
    static List<P> list;

    static class P implements Comparable<P> {
        int diff, pos;

        public P(int diff, int pos) {
            this.diff = diff;
            this.pos = pos;
        }

        @Override
        public int compareTo(P o) {
            return this.diff - o.diff;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i > 0) {
                list.add(new P(arr[i] - arr[i - 1], i - 1));
            }
        }

        Collections.sort(list);

        int ans = 0;

        for (int i = 0; i < n - k; i++) {
            P p = list.get(i);
            ans += p.diff;
        }

        System.out.println(ans);

        br.close();
    }


}
