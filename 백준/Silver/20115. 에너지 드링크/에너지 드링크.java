import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static double[] drinks;
    static double ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        drinks = new double[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(drinks);

        for (int i = 0; i < n - 1; i++) {
            ans += drinks[i] / 2;
        }
        ans += drinks[n - 1];

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

}

