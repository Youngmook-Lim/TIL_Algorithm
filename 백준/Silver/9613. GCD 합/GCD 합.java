import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static long ans;
    static int[] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            ans = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    ans += getGcd(arr[i], arr[j]);
                }
            }
            sb.append(ans).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }


}
