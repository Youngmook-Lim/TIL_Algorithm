import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int m;
    public static int n;
    public static int[] arr;

    public static void bin(int start, int end) {
        if (start > end) return;

        int mid = (start + end) / 2;
        int cnt = 0;
        int total = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            total += arr[i];
            if (total > mid) {
                cnt++;
                max = Integer.max(max, total - arr[i]);
                total = arr[i];
            } else if (i == n - 1) {
                cnt++;
                max = Integer.max(max, total);
            }
        }
        if (cnt == m) {
            System.out.println(start);
            return;
        } else if (cnt > m) {
            bin(mid + 1, end);
        } else {
            bin(start, mid - 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int start = 0;
        int end = 0;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
            if (arr[i] > start) {
                start = arr[i];
            }
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 1;
            int total = 0;

            for (int i = 0; i < n; i++) {
                total += arr[i];
                if (total > mid) {
                    cnt++;
                    total = arr[i];
                }
            }

            if (cnt > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);

        br.close();
    }
}


