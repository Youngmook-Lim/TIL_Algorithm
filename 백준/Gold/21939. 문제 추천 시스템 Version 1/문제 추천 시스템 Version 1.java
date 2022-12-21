import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static TreeSet<P> ts;
    static Map<Integer, Integer> pos;

    static class P implements Comparable<P> {
        int p, l;

        public P(int p, int l) {
            this.p = p;
            this.l = l;
        }

        @Override
        public int compareTo(P o) {
            if (this.l != o.l) {
                return this.l - o.l;
            }
            return this.p - o.p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        ts = new TreeSet<>();
        pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            ts.add(new P(p, l));
            pos.put(p, l);
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    sb.append(ts.last().p).append('\n');
                } else {
                    sb.append(ts.first().p).append('\n');
                }
            } else if (cmd.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                ts.add(new P(p, l));
                pos.put(p, l);
            } else {
                int p = Integer.parseInt(st.nextToken());
                P rm = new P(p, pos.get(p));
                ts.remove(rm);
                pos.remove(p);
            }
        }

        System.out.println(sb);

        br.close();
    }


}
