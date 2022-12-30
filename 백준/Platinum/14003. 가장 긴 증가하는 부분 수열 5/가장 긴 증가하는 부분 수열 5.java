import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n, idx;
    static int[] arr, LIS, LISIndexes;
    static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        LIS = new int[n];
        LISIndexes = new int[n];
        idx = 0;
        stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i] > LIS[idx - 1]) {
                LIS[idx++] = arr[i];
                LISIndexes[i] = idx - 1;
            } else {
                int pos = findIndex(0, idx - 1, arr[i]);
                LIS[pos] = arr[i];
                LISIndexes[i] = pos;
            }
        }

//        int tmpIdx = idx - 1;

        for (int i = n - 1, tmpIdx = idx - 1; i >= 0 && tmpIdx >= 0; i--) {
            if (LISIndexes[i] != tmpIdx) continue;

            stack.push(arr[i]);
            tmpIdx--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(idx).append('\n');

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);

        br.close();
    }

    static int findIndex(int start, int end, int target) {
        if (start > end) {
            return start;
        }

        int mid = (start + end) / 2;

        if (LIS[mid] < target) {
            return findIndex(mid + 1, end, target);
        } else {
            return findIndex(start, mid - 1, target);
        }

    }


}

