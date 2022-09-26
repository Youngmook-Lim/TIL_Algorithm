import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int n;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i < n; i++) {
            ans += (long) (arr[i] - arr[i - 1]) * (arr[n] - arr[i]);
        }


        bw.write(ans + "\n");


        bw.flush();
        bw.close();
        br.close();
    }


}
