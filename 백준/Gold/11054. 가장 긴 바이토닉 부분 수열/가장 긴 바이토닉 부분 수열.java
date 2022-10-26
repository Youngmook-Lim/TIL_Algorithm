import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 배열을 순회하며 각 요소를 꼭지점으로 가정하고, 그 기준으로 증가하고 감소하는 부분수열의 길이을 합한 것을 구한다.
 * */
public class Main {

    static int n, ans;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp = new int[n];
            int maxLower = 0;
            for (int j = i - 1; j >= 0; j--) {
                for (int k = j + 1; k <= i; k++) {
                    if (arr[j] < arr[k]) {
                        dp[j] = Math.max(dp[j], dp[k] + 1);
                    }
                }
                maxLower = Math.max(maxLower, dp[j]);
            }

            int maxUpper = 0;
            for (int j = i + 1; j < n; j++) {
                for (int k = j - 1; k >= i; k--) {
                    if (arr[j] < arr[k]) {
                        dp[j] = Math.max(dp[j], dp[k] + 1);
                    }
                }
                maxUpper = Math.max(maxUpper, dp[j]);
            }
//            System.out.println(i);
//            System.out.println(maxLower);
//            System.out.println(maxUpper);
//            System.out.println(Arrays.toString(dp));
//            System.out.println("--------");
            ans = Math.max(ans, maxLower + maxUpper + 1);
        }

        System.out.println(ans);

        br.close();
    }


}

