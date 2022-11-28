import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int posA = binSearchLow(a, 0, n - 1);
            int posB = binSearchHigh(b, 0, n - 1);
            sb.append(posB - posA + 1).append('\n');
        }
        System.out.println(sb);

        br.close();
    }

    static int binSearchLow(int target, int start, int end) {
        if (start > end) return start;

        int mid = (start + end) / 2;

        if (arr[mid] >= target) {
            return binSearchLow(target, start, mid - 1);
        } else {
            return binSearchLow(target, mid + 1, end);
        }
    }

    static int binSearchHigh(int target, int start, int end) {
        if (start > end) return end;

        int mid = (start + end) / 2;

        if (arr[mid] > target) {
            return binSearchHigh(target, start, mid - 1);
        } else {
            return binSearchHigh(target, mid + 1, end);
        }
    }

}






