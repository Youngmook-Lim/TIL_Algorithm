import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static long[] arr;
    static List<Long> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        ans = new ArrayList<>();

        long min = Long.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int start = i + 1;
            int end = n - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                long total = arr[i] + arr[mid];

                if (Math.abs(total) < min) {
                    min = Math.abs(total);
                    ans.clear();
                    ans.add(arr[i]);
                    ans.add(arr[mid]);
                }
                if (total < 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            }
        }

        Collections.sort(ans);

        for (long x : ans) {
            System.out.print(x + " ");
        }

        br.close();

    }

}