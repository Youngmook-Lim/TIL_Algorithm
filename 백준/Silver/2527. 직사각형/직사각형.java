import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int x1;
    static int y1;
    static int p1;
    static int q1;
    static int x2;
    static int y2;
    static int p2;
    static int q2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            p1 = Integer.parseInt(st.nextToken());
            q1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            p2 = Integer.parseInt(st.nextToken());
            q2 = Integer.parseInt(st.nextToken());

            if (p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) {
                bw.write("d" + "\n");
            } else if ((p1 == x2 && q1 == y2) || (x1 == p2 && q1 == y2) ||
                    (x1 == p2 && y1 == q2) || (p1 == x2 && y1 == q2)) {
                bw.write("c" + "\n");
            } else if (p1 == x2 || q1 == y2 || p2 == x1 || q2 == y1) {
                bw.write("b" + "\n");
            } else {
                bw.write("a" + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

}

