import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer> list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        sb = new StringBuilder();

        dfs(0, 1);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int idx) {
        if (depth == m) {
            for (int x : list) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i <= n; i++) {
            list.add(i);
            dfs(depth + 1, i);
            list.remove(list.size() - 1);
        }
    }

}