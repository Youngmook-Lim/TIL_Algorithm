import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;

    static Stack<Integer> stack;
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        stack = new Stack<>();
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs() {
        if (stack.size() == m) {
            for (int x : stack) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            stack.push(arr[i]);
            dfs();
            stack.pop();
        }

    }

}