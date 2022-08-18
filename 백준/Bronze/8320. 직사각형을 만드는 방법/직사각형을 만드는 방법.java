import java.io.*;

public class Main {

    static int n;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.floor(Math.sqrt(i)); j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }
        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}

