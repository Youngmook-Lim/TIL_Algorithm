import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static String seats;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        seats = br.readLine();

        for (int i = 0; i < n; i++) {
            if (seats.charAt(i) == 'L') {
                cnt++;
                i++;
            } else {
                cnt++;
            }
        }

        if (cnt > n) {
            bw.write(n + "\n");
        } else {
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}

