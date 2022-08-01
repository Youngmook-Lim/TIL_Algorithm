import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static boolean flag = false;
    public static int[] arr1;
    public static int[] arr2;

    public static void bin(int start, int end, int target) {
        if (start > end) return;

        int mid = (start + end) / 2;

        if (arr1[mid] == target) {
            flag = true;
            return;
        } else if (arr1[mid] > target) {
            bin(start, mid - 1, target);
        } else {
            bin(mid + 1, end, target);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            arr1 = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            arr2 = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr1);

            StringBuilder sb = new StringBuilder();
            for (int i : arr2) {
                bin(0, arr1.length - 1, i);
                if (!flag) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                    flag = false;
                }
            }
            System.out.print(sb);
        }

        br.close();
    }
}
