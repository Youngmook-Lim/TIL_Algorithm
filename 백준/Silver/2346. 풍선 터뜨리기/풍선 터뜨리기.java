import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {

    static class P {
        int num, idx;

        public P(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        ArrayDeque<P> q = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(new P(Integer.parseInt(st.nextToken()), i + 1));
        }

        while (!q.isEmpty()) {
            P p = q.pollFirst();
            sb.append(p.idx).append(' ');
            if (q.isEmpty()) break;
            if (p.num > 0) {
                for (int i = 0; i < p.num - 1; i++) {
                    q.add(q.pollFirst());
                }
            } else {
                for (int i = 0; i < -p.num; i++) {
                    q.addFirst(q.pollLast());
                }
            }
        }

        System.out.println(sb);

        br.close();
    }


}

