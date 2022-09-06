import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int k;
    static int[] arr;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            arr = new int[k];
            list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0);
            bw.write("\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int idx) throws IOException {
        if (list.size() == 6) {
            for (Integer x : list) {
                bw.write(x + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = idx; i < k; i++) {
            list.add(arr[i]);
            dfs(i + 1);
            list.remove(list.size() - 1);
        }
    }

}