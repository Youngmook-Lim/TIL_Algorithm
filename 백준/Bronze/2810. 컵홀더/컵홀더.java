import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static String seats;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        seats = br.readLine();
        int num = n;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (seats.charAt(i) == 'L') {
                num--;
                i++;
                flag = true;
            }
        }

        if (flag) num++;

        bw.write(num + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

}

