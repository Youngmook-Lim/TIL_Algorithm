import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int multiplier = 1;
        int total = 1;

        while (true) {
            if (n <= total) {
                bw.write(cnt + "\n");
                break;
            }
            total += 6 * multiplier;
            cnt++;
            multiplier++;
        }

        bw.flush();
        bw.close();
        br.close();

    }


}

