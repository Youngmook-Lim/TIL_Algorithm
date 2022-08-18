import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[l];
        int maxDif = 0;
        int maxDifNum = 0;
        int maxCake = 0;
        int maxCakeNum = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dif = end - start + 1;
            if (dif > maxDif) {
                maxDif = dif;
                maxDifNum = i;
            }

            int cnt = 0;
            for (int j = start; j <= end; j++) {
                if (arr[j - 1] == 0) {
                    arr[j - 1] = 1;
                    cnt++;
                }
            }
            if (cnt > maxCake) {
                maxCake = cnt;
                maxCakeNum = i;
            }
        }

        bw.write(maxDifNum + "\n");
        bw.write(maxCakeNum + "\n");


        bw.flush();
        bw.close();
        br.close();

    }

}

