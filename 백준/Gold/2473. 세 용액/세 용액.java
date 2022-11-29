import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    static int n;
    static long[] arr, ans;
    static boolean flag;
    static long minAbsSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        ans = new long[n];
        minAbsSum = Long.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            find(arr[i], i + 1, n - 1);
            if (flag) break;
        }

        StringBuilder sb = new StringBuilder();
        for (long x : ans) {
            sb.append(x).append(' ');
        }

        System.out.println(sb);

        br.close();
    }

    static void find(long num, int start, int end) {
        if (flag) return;
        if (start >= end) return;

        long sum = num + arr[start] + arr[end];

        if (Math.abs(sum) < minAbsSum) {
            minAbsSum = Math.abs(sum);
            ans[0] = num;
            ans[1] = arr[start];
            ans[2] = arr[end];
        }

        if (sum == 0) {
            flag = true;
        } else if (sum > 0) {
            find(num, start, end - 1);
        } else {
            find(num, start + 1, end);
        }
    }

}
