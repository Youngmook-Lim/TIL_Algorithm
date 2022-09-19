import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int start = 64;
        int len = 6;

        while (start > x) {
            start >>= 1;
            len--;
        }
        start <<= 1;
        len++;

        for (int i = 0; i < start; i++) {
            int sum = 0;
            int n = 0;
            for (int j = 0; j < len + 1; j++) {
                int tmp = i & (1 << j);
                if (tmp != 0) {
                    sum += tmp;
                    n++;
                }
            }
            if (sum == x) {
                System.out.println(n);
                break;
            }
        }

        br.close();
    }


}