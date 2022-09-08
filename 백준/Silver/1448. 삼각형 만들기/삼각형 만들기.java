import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        boolean flag = false;

        for (int i = n - 1; i >= 2; i--) {
            if (arr[i] < arr[i - 1] + arr[i - 2]) {
                flag = true;
                max = Math.max(max, arr[i] + arr[i - 1] + arr[i - 2]);
            } else {
                if (flag) break;
            }

        }
        if (flag) {
            bw.write(max + "\n");
        } else {
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}