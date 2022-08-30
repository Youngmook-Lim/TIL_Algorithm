import java.io.*;
import java.util.*;

public class Main {

    static Stack<Integer> stack;
    static boolean[] visited;
    static Set<List<Integer>> set;
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        stack = new Stack<>();
        set = new LinkedHashSet<>();
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (List<Integer> x : set) {
            for (int a : x) {
                sb.append(a).append(" ");
            }
            sb.append("\n");

        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int idx) {
        if (stack.size() == m) {
            set.add(new ArrayList<>(stack));
            return;
        }

        for (int i = idx; i < n; i++) {
            stack.push(arr[i]);
            dfs(i);
            stack.pop();
        }
    }
}