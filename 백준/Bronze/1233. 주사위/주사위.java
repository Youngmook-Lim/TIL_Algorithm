import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int s3 = Integer.parseInt(st.nextToken());
        int[] arr = new int[s1 + s2 + s3 + 1];
        int max = 0;

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    max = Math.max(max, ++arr[i + j + k]);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                bw.write(i + "\n");
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}