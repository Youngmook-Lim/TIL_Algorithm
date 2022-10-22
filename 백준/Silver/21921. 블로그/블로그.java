import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, x, cnt;
    static long ans, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ans = 0;
        cnt = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i < x) {
                sum += arr[i];
            }
        }
        ans = Math.max(ans, sum);

        for (int i = x; i < n; i++) {
            sum = sum + arr[i] - arr[i - x];
            if (sum >= ans) {
                if (sum == ans) {
                    cnt++;
                } else {
                    ans = sum;
                    cnt = 1;
                }
            }
        }

        if (ans == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(ans);
            System.out.println(cnt);
        }


        br.close();
    }


}

