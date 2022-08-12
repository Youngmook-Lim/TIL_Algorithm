import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int start;
    static int end;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int ans = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int father = Integer.parseInt(st.nextToken());
            int son = Integer.parseInt(st.nextToken());
            graph.get(father).add(son);
            graph.get(son).add(father);
        }

        dfs(start, 0);

        if (ans != 0) {
            bw.write(ans + "\n");
        } else {
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int start, int cnt) {
        visited[start] = true;
        if (start == end) {
            ans = cnt;
        }
        for (int x : graph.get(start)) {
            if (!visited[x]) {
                dfs(x, cnt + 1);
            }
        }

    }
}

