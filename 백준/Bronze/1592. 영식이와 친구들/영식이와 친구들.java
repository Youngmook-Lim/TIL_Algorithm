import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int max = 0;
        int curIdx = 0;
        int cnt = 0;

        while (max < m) {
            arr[curIdx]++;
            cnt++;
            max = Integer.max(max, arr[curIdx]);
            if (arr[curIdx] % 2 == 1) {
                curIdx = (curIdx + l) % n;
            } else {
                curIdx = (curIdx + n - l) % n;
            }
        }

        bw.write(cnt - 1 + "\n");

        bw.flush();
        bw.close();
        br.close();

    }


}

