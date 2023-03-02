import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static List<Integer> list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[n];

        dfs(0);
        System.out.println(sb);

        br.close();
    }

    public static void dfs(int depth) {
        if (depth == n) {
            for (int x : list) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(i + 1);
            dfs(depth + 1);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

}


