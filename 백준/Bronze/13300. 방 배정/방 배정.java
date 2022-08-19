import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[2][7];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            arr[sex][grade]++;
            if (arr[sex][grade] > k) {
                arr[sex][grade] = 1;
            }
            if (arr[sex][grade] == 1) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

}
