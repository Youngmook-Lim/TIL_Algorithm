import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long ans;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n / 2; i++) {
            long sum;
            if (n % 2 == 0) {
                sum = arr[i] + arr[n - i - 1];
            } else {
                sum = arr[i] + arr[n - i - 2];
            }
            ans = Math.max(ans, sum);
        }

//        if (n % 2 != 0) {
//            ans = Math.max(ans, arr[n - 1]);
//        }

        System.out.println(ans);

        br.close();
    }


}
