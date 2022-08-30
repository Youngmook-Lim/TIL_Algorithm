import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int n;
    static long ans;
    static Queue<Long> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(Long.parseLong(br.readLine()));
        }

        if (n > 1) {
            while (q.size() != 1) {
                long x = q.poll();
                long y = q.poll();
                ans += x + y;
                q.add(x + y);
            }
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}