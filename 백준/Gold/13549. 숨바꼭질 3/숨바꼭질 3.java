import java.io.*;
import java.util.*;

public class Main {

    static int n, k, ans;
    static int MAX = 200000;
    static boolean[] visited;

    static class P {
        int x, sec;

        P(int x, int sec) {
            this.x = x;
            this.sec = sec;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;

        visited = new boolean[MAX + 1];

        bfs(n);

        bw.write(ans + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start) {
        Queue<P> q = new LinkedList<>();
        q.add(new P(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            P p = q.poll();

            if (p.x == k) {

                if (p.sec < ans) {
                    ans = p.sec;
                }
                continue;
            }
            visited[p.x] = true;


            if (p.x * 2 <= MAX && !visited[p.x * 2] && p.x < k) {
                q.add(new P(p.x * 2, p.sec));
            }
            if (p.x + 1 <= MAX && !visited[p.x + 1]) {
                q.add(new P(p.x + 1, p.sec + 1));

            }
            if (p.x - 1 >= 0 && !visited[p.x - 1]) {
                q.add(new P(p.x - 1, p.sec + 1));
            }

        }

    }


}

