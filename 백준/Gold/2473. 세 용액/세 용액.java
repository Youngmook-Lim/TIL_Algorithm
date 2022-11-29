import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    static int n;
    static long[] arr;
    static List<Long> ans;
    static long minAbsSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        ans = new ArrayList<>();
        minAbsSum = Long.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            find(arr[i], i + 1, n - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (long x : ans) {
            sb.append(x).append(' ');
        }

        System.out.println(sb);

        br.close();
    }

    static void find(long num, int start, int end) {
        if (start >= end) return;

        long sum = num + arr[start] + arr[end];

        if (Math.abs(sum) < minAbsSum) {
            minAbsSum = Math.abs(sum);
            ans.clear();
            ans.add(num);
            ans.add(arr[start]);
            ans.add(arr[end]);
        }

        if (sum > 0) {
            find(num, start, end - 1);
        } else {
            find(num, start + 1, end);
        }
    }

}
