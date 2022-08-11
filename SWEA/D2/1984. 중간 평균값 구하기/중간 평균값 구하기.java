
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] arr;
    static int[] sorted;
    static int[] count;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            double ans = 0;
            arr = new int[10];
            sorted = new int[10];
            max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] > max) {
                    max = arr[i];
                }
            }

            count = new int[max + 1];

            for (int x : arr) {
                count[x]++;
            }

            for (int i = 1; i < max + 1; i++) {
                count[i] += count[i - 1];
            }

            for (int i = 9; i >= 0; i--) {
                int idx = --count[arr[i]];
                sorted[idx] = arr[i];
            }


            for (int i = 1; i < 9; i++) {
                ans += sorted[i];
            }

            ans /= 8;

            System.out.println("#" + t + " " + Math.round(ans));
        }
        br.close();
    }
}