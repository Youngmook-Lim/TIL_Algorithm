import java.io.*;
import java.util.*;

public class Main {

    static int w;
    static int h;
    static int n;

    static int[][] dist;
    static int[] me;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());
        dist = new int[n][2];
        me = new int[2];

        int round = 2 * (w + h);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dist[i][0] = Integer.parseInt(st.nextToken());
            dist[i][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        me[0] = Integer.parseInt(st.nextToken());
        me[1] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            if (me[0] == dist[i][0]) {
                total += Math.abs(me[1] - dist[i][1]);
            } else if (me[0] + dist[i][0] == 3) {
                int a = h + me[1] + dist[i][1];
                int b = round - a;
                total += Math.min(a, b);
            } else if (me[0] + dist[i][0] == 7) {
                int a = w + me[1] + dist[i][1];
                int b = round - a;
                total += Math.min(a, b);
            } else if ((me[0] == 1 && dist[i][0] == 3) || (me[0] == 3 && dist[i][0] == 1)) {
                total += me[1] + dist[i][1];
            } else if ((me[0] == 2 && dist[i][0] == 3) || (me[0] == 3 && dist[i][0] == 2)) {
                if (me[0] == 2) {
                    total += me[1] + h - dist[i][1];
                } else {
                    total += h - me[1] + dist[i][1];
                }
            } else if ((me[0] == 2 && dist[i][0] == 4) || (me[0] == 4 && dist[i][0] == 2)) {
                total += w + h - me[1] - dist[i][1];
            } else {
                if (me[0] == 4) {
                    total += me[1] + w - dist[i][1];
                } else {
                    total += w - me[1] + dist[i][1];
                }
            }
        }

        bw.write(total + "\n");

        bw.flush();
        bw.close();
        br.close();

    }


}

