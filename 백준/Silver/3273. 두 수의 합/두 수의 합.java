import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, x, ans;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == x) {
                ans++;
            }
            if (sum > x) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(ans);

        br.close();
    }


}
