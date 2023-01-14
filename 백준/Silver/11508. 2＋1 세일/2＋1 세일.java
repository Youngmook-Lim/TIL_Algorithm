import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int idx = n - 1;

        while (idx >= 0) {
            if (idx > 1) {
                ans += arr[idx] + arr[idx - 1];
                idx -= 3;
            } else {
                ans += arr[idx];
                idx--;
            }
        }

        System.out.println(ans);

        br.close();
    }


}
