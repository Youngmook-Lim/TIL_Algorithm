import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int f, s, g, u, d, ans;
    static boolean[] visited;

    static class P {
        int pos, cnt;

        public P(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        ans = -1;
        visited = new boolean[f + 1];

        Queue<P> q = new ArrayDeque<>();
        q.add(new P(s, 0));
        while (!q.isEmpty()) {
            P p = q.poll();
//            System.out.println(p.pos + " " + p.cnt);

            if (p.pos == g) {
                ans = p.cnt;
                break;
            }

            for (int k = 0; k < 2; k++) {
                int move = k == 0 ? u : -d;
                int nPos = p.pos + move;

                if (nPos <= 0 || nPos > f || visited[nPos]) continue;

                visited[nPos] = true;
                q.add(new P(nPos, p.cnt + 1));
            }

        }

        if (ans == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(ans);
        }

        br.close();
    }


}
