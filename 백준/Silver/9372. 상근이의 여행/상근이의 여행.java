import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static List<Integer>[] adj;
    static boolean[] visited;
    static int n, m, T;
    static int cnt;
    static int visitCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            cnt = 0;
            visitCnt = n;
            visited = new boolean[n + 1];
            adj = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                adj[b].add(a);
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    cnt--;
                    search(i);
                }
                if (visitCnt == 0) break;
            }

            sb.append(cnt).append('\n');

        }

        System.out.println(sb);

        br.close();
    }

    static void search(int node) {
//        System.out.println("Node : " + node);
        visited[node] = true;
        visitCnt--;
        cnt++;

        for (int next : adj[node]) {
            if (!visited[next]) {
//                visited[next] = true;
                search(next);
            }
        }
    }


}
