import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k, ans;
    static Queue<Integer> pq;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        int prev = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prev = Integer.parseInt(st.nextToken());
            } else {
                int tmp = Integer.parseInt(st.nextToken());
                pq.add(tmp - prev);
                prev = tmp;
            }
        }
        
        for (int i = 0; i < n - k; i++) {
            ans += pq.poll();
        }

        System.out.println(ans);

        br.close();
    }


}
