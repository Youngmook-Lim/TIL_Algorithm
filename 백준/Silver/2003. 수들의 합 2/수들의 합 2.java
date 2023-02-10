import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i + 1] = arr[i] + num;
        }

        int ans = twoPointer(n, m, arr);

        System.out.println(ans);

        br.close();
    }

    static int twoPointer(int n, int m, int[] arr) {
        int start = 0;
        int end = 1;
        int cnt = 0;

        while (end <= n) {
            if (arr[end] - arr[start] == m) {
                cnt++;
                end++;
            } else if (arr[end] - arr[start] < m) {
                end++;
            } else {
                start++;
            }
        }

        return cnt;
    }


}














