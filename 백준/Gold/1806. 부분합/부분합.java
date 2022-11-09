import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, s, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        ans = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num >= s) {
                System.out.println(1);
                return;
            }
            arr[i] = num + arr[i - 1];
        }

        int start = 0;
        int end = 1;
        while (end < n + 1) {
            int subTotal = arr[end] - arr[start];
            if (subTotal < s) {
                end++;
            } else {
                ans = Math.min(ans, (end - start));
                start++;
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);

        br.close();
    }


}

