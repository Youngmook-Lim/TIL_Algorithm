import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, ans;
    static Queue<P> pq;
    static Queue<Integer> pq2;

    static class P implements Comparable<P> {
        int start, end;

        public P(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(P o) {
            if (this.start != o.start) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        pq2 = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new P(start, end));
        }

        while (!pq.isEmpty()) {
            P p = pq.poll();
            if (!pq2.isEmpty() && pq2.peek() <= p.start) {
                pq2.poll();
            }
            pq2.add(p.end);
        }

        System.out.println(pq2.size());

        br.close();
    }


}
