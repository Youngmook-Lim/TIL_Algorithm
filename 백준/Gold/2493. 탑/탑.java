import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Stack<Integer> stack, stackIdx;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        stack = new Stack<>();
        stackIdx = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            while (!stack.isEmpty() && stack.peek() < cur) {
                stack.pop();
                stackIdx.pop();
            }
            if (stack.isEmpty()) {
                sb.append(0).append(' ');
            } else {
                sb.append(stackIdx.peek()).append(' ');
            }
            stack.push(cur);
            stackIdx.push(i + 1);
        }

        System.out.println(sb);

        br.close();
    }


}
