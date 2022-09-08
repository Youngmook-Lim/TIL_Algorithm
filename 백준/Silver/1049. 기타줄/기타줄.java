import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m, ans, min_six, min_one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        min_one = Integer.MAX_VALUE;
        min_six = Integer.MAX_VALUE;


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            min_six = Math.min(min_six, Integer.parseInt(st.nextToken()));
            min_one = Math.min(min_one, Integer.parseInt(st.nextToken()));
        }


        if (min_six < 6 * min_one) {
            int a = n / 6;
            ans += a * min_six;
            n -= a * 6;
            if (min_six < n * min_one) {
                ans += min_six;
            } else {
                ans += n * min_one;
            }
        } else {
            ans += min_one * n;
        }


        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}