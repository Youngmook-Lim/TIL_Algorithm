import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        dfs();
        
        br.close();
    }

    static void dfs() {
        if (list.size() == m) {
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (list.contains(i)) continue;
            list.add(i);
            dfs();
            list.remove(list.size() - 1);
        }
    }

}