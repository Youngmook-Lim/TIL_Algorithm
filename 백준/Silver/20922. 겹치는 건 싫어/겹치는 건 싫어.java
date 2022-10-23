import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k, left, right, ans;
    static int[] arr, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cnt = new int[100001];
        left = 0;
        right = -1;

        while (right < n - 1) {
            right++;
            if (cnt[arr[right]] < k) {
                cnt[arr[right]]++;
            } else {
                while (arr[left] != arr[right]) {
                    cnt[arr[left]]--;
                    left++;
                }
                left++;
            }

            int len = right - left + 1;
//            System.out.println(len);
            ans = Math.max(ans, len);

        }

        System.out.println(ans);

        br.close();
    }


}

