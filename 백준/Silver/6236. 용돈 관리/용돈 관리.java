import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end += arr[i];
            if (arr[i] > start) {
                start = arr[i];
            }
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 1;
            int total = 0;
            for (int i = 0; i < n; i++) {
                total += arr[i];
                if (total > mid) {
                    cnt++;
                    total = arr[i];
                }
            }
//            System.out.println(start + " " + mid + " " + end + ": " + cnt);

            if (cnt <= m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }


        }
        System.out.println(start);


        br.close();
    }
}


