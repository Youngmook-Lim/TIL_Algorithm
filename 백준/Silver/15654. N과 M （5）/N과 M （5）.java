import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list;
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth) {

        if (depth == m) {
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (list.contains(arr[i])) continue;
            list.add(arr[i]);
            dfs(depth + 1);
            list.remove(list.size() - 1);
        }

    }

}