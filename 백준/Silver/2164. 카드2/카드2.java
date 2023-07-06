import java.io.*;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        int cnt = 1;

        while (true) {
            if (cnt >= n) {
                bw.write(2 * n - cnt + "\n");
                break;
            }
            cnt *= 2;
        }

        bw.flush();
        bw.close();
        br.close();

    }

}

