import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static final int MAX = 200001;
    static int n, k, howMany, limit;
    static int[] visited;
    static Queue<P> q;
    static boolean flag;

    static class P {
        int num, cnt;

        public P(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n > k) {
            System.out.println(n - k);
            System.out.println(1);
            return;
        }

        visited = new int[MAX];
        Arrays.fill(visited, MAX + 1);
        q = new ArrayDeque<>();

        q.add(new P(n, 0));
        visited[n] = 0;

        while (!q.isEmpty()) {
            P p = q.poll();

            if (flag && p.cnt > limit) {
                break;
            }

            if (p.num == k) {
                flag = true;
                limit = p.cnt;
                howMany++;
                continue;
            }

            int twice = p.num * 2;
            int add = p.num + 1;
            int minus = p.num - 1;

            if (twice < MAX && visited[twice] >= p.cnt + 1) {
                if (twice != k) {
                    visited[twice] = p.cnt + 1;
                }
                q.add(new P(twice, p.cnt + 1));
            }
            if (add < MAX && visited[add] >= p.cnt + 1) {
                if (add != k) {
                    visited[add] = p.cnt + 1;
                }
                q.add(new P(add, p.cnt + 1));
            }
            if (minus >= 0 && visited[minus] >= p.cnt + 1) {
                if (minus != k) {
                    visited[minus] = p.cnt + 1;
                }
                q.add(new P(minus, p.cnt + 1));
            }

        }

        System.out.println(limit);
        System.out.println(howMany);

        br.close();
    }


}

