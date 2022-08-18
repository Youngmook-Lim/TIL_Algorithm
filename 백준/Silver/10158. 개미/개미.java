import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int w, h, p, q, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(br.readLine());

        int x, y;

        x = w - Math.abs(w - (p + t) % (w * 2));
        y = h - Math.abs(h - (q + t) % (h * 2));

        bw.write(x + " " + y + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}