import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (l == 0 && p == 0 && v == 0) {
                break;
            }

            int ans = 0;

            int tmp = v / p;
            ans += (l * tmp);
            v -= tmp * p;

            ans += Integer.min(v, l);

            bw.write("Case " + i + ": " + ans + "\n");
            i++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}