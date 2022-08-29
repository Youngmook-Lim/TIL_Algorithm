import java.io.*;
import java.util.*;

public class Main {

    static Stack<Integer> stack;
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

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

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs() {

        if (stack.size() == m) {
            for (int x : stack) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (stack.contains(arr[i])) continue;
            stack.push(arr[i]);
            dfs();
            stack.pop();
        }

    }

}