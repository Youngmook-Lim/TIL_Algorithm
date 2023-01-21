import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<P> list;
    static Queue<Integer> pq;

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
        list = new ArrayList<>();
        pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new P(start, end));
        }

        Collections.sort(list);

        for (P p : list) {
            if (!pq.isEmpty() && pq.peek() <= p.start) {
                pq.poll();
            }
            pq.add(p.end);
        }

        System.out.println(pq.size());

        br.close();
    }


}
