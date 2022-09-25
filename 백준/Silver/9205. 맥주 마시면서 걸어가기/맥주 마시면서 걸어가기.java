import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, xHome, yHome, xGoal, yGoal;
    static boolean[] visited;
    static String ans;
    static List<P> list;

    static class P {
        int x, y;

        P(int y, int x) {
            this.x = x;
            this.y = y;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n];
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            xHome = Integer.parseInt(st.nextToken());
            yHome = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int xStore = Integer.parseInt(st.nextToken());
                int yStore = Integer.parseInt(st.nextToken());
                list.add(new P(yStore, xStore));
            }
            st = new StringTokenizer(br.readLine());
            xGoal = Integer.parseInt(st.nextToken());
            yGoal = Integer.parseInt(st.nextToken());
            ans = "sad";

            bfs();

            System.out.println(ans);

        }


        br.close();
    }

    static void bfs() {
        Queue<P> q = new LinkedList<>();
        q.add(new P(yHome, xHome));
        while (!q.isEmpty()) {
            P p = q.poll();

            if (Math.abs(p.x - xGoal) + Math.abs(p.y - yGoal) <= 1000) {
                ans = "happy";
                return;
            }

            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;
                P next = list.get(i);
                if (Math.abs(p.x - next.x) + Math.abs(p.y - next.y) <= 1000) {
                    visited[i] = true;
                    q.add(next);
                }

            }


        }
    }


}
