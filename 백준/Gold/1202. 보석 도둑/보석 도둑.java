import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, k;
    static long ans;
    static Queue<P> pq;

    static class P implements Comparable<P> {
        int m;
        long v;

        public P(int m, long v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(P o) {
            if (this.v != o.v) {
                return Long.compare(o.v, this.v);
            }
            return this.m - o.m;
        }
    }

    static TreeSet<Integer> bags;
    static Map<Integer, Integer> cntBags;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        bags = new TreeSet<>();
        cntBags = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            pq.add(new P(m, v));
        }
        for (int i = 0; i < k; i++) {
            int c = Integer.parseInt(br.readLine());
            if (cntBags.containsKey(c)) {
                cntBags.put(c, cntBags.get(c) + 1);
            } else {
                cntBags.put(c, 1);
                bags.add(c);
            }
        }
        bags.add(Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            P p = pq.poll();
            int nearestBag = bags.ceiling(p.m);
            if (nearestBag == Integer.MAX_VALUE) continue;
            ans += p.v;
            int cnt = cntBags.get(nearestBag);
            cntBags.put(nearestBag, cnt - 1);
            if (cnt == 1) {
                bags.remove(nearestBag);
            }
        }
        System.out.println(ans);

        br.close();
    }
}
