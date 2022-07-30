import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static long n;
    public static long[] arr;
    public static long m;

    public static void bin(long start, long end) {
        if (start > end) return;
        long mid = (start + end) / 2;
//        System.out.println(mid);


        long total1 = 0;
        for (long i : arr) {
            if (i <= mid) {
                total1 += i;
            } else {
                total1 += mid;
            }
        }

        long total2 = 0;

        for (long i : arr) {
            if (i <= mid + 1) {
                total2 += i;
            } else {
                total2 += mid + 1;
            }
        }
//        System.out.println(total1);
//        System.out.println(total2);

        if (total1 <= m && total2 > m) {
            System.out.println(mid);
            return;
        } else if (total1 > m) {
            bin(start, mid - 1);
        } else {
            bin(mid + 1, end);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        arr = new long[(int) n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());

        long totalT = Arrays.stream(arr).sum();

        if (totalT <= m) {
            System.out.println(Arrays.stream(arr).max().getAsLong());
        } else {
            bin(0, 2000000000);
        }


        br.close();
    }
}
