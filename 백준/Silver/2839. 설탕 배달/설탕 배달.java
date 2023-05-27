import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        int quo = n / 5;
        cnt += quo;
        n -= quo * 5;

        switch (n) {
            case 4:
                if (cnt > 0) {
                    cnt += 2;
                } else {
                    cnt = -1;
                }
                break;
            case 3:
                cnt++;
                break;
            case 2:
                if (cnt > 1) {
                    cnt += 2;
                } else {
                    cnt = -1;
                }
                break;
            case 1:
                if (cnt > 0) {
                    cnt++;
                } else {
                    cnt = -1;
                }
                break;
        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

}
