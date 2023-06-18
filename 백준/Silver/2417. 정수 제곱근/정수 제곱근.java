import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static long n, ans;
    static final double MAX_SQRT = Math.sqrt(Long.MAX_VALUE);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Long.parseLong(br.readLine());

        bs(0, n);

        System.out.println(ans);

        br.close();

    }

    static void bs(long start, long end) {
        if (start > end) return;
//        System.out.println(start + " " + end);

        long mid = (start + end) / 2;

        double res;
        if (mid >= MAX_SQRT) {
            res = n;
        } else {
            res = Math.pow(mid, 2);
        }

        if (res >= n) {
            ans = mid;
            bs(start, mid - 1);
        } else {
            bs(mid + 1, end);
        }
    }

}