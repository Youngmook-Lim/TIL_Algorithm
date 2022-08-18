import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] remainders = new int[42];

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            if (remainders[n % 42] == 0) {
                remainders[n % 42]++;
            }
        }

        bw.write(Arrays.stream(remainders).sum() + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

}

