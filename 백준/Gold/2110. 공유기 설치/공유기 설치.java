import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int start = 1;
        int end = 0;

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
//            if (start > arr[i]) {
//                start = arr[i];
//            }
        }

        Arrays.sort(arr);
        end = arr[n - 1] - arr[0];

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 1;
            int idx = 0;
            int total = 0;
            for (int i = 1; i < n; i++) {

                total = arr[i] - arr[idx];
                if (total >= mid) {
                    cnt++;
                    idx = i;
                    total = 0;
                }
            }


//            System.out.println(start + " " + mid + " " + end + ": " + cnt);

            if (cnt < c) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);


        br.close();

    }

}



