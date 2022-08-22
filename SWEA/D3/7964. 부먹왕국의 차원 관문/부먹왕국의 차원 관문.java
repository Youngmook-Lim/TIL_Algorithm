import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int d;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;

            for (int i = -1; i < n - d; i++) {
                boolean flag = true;
                for (int j = i + 1; j < i + d + 1; j++) {
                    if (arr[j] == 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    arr[i + d] = 1;
                    ans++;
                }

            }

            bw.write("#" + t + " " + ans + "\n");

        }


        bw.flush();
        bw.close();
        br.close();

    }

}