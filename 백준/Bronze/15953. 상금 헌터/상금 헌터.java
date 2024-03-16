import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] aArr = {500, 300, 200, 50, 30, 10};
        int[] bArr = {512, 256, 128, 64, 32};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int amount = 0;

            if (a > 0 && a < 22) {
                int tmp = 1;
                int idx = 0;
                while (a > 0) {
                    a -= tmp++;
                    idx++;
                }
                amount += aArr[idx - 1];
            }

            if (b > 0 && b < 32) {
                int tmp = 1;
                int idx = 0;
                while (b > 0) {
                    b -= tmp;
                    tmp *= 2;
                    idx++;
                }
                amount += bArr[idx - 1];
            }
            sb.append(amount * 10000).append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}


