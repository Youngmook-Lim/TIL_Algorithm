import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            Queue<String> q1 = new LinkedList<>();
            Queue<String> q2 = new LinkedList<>();

            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                if (n % 2 == 0) {
                    if (i < n / 2) {
                        q1.add(st.nextToken());
                    } else {
                        q2.add(st.nextToken());
                    }
                } else {
                    if (i < n / 2 + 1) {
                        q1.add(st.nextToken());
                    } else {
                        q2.add(st.nextToken());
                    }
                }
            }


            bw.write("#" + t + " ");
            for (int i = 0; i < n / 2; i++) {
                bw.write(q1.poll() + " ");
                bw.write(q2.poll() + " ");
            }

            if (!q1.isEmpty()) {
                bw.write(q1.poll());
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}