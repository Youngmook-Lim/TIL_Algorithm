import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arrA = new int[n];
            int[] arrB = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            int cnt = 0;

            for (int i = 0; i < n; i++) {
                int start = 0;
                int end = m - 1;

                while (start <= end) {
                    int mid = (start + end) / 2;

                    if (arrA[i] <= arrB[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }

                cnt += start;

            }
            System.out.println(cnt);

        }

        br.close();
    }
}


