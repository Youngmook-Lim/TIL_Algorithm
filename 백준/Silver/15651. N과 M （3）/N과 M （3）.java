import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;

    static List<Integer> list = new ArrayList<>();

    static void dfs(int cnt) {
        if (cnt == m) {
            for (int x : list) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            list.add(i);
            dfs(cnt + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0);
        System.out.println(sb);

        br.close();

    }

}



