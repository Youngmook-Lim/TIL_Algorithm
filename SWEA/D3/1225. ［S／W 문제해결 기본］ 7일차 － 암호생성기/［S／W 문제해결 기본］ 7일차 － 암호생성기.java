import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= 10; t++) {
            int _ = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 8; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            int counter = 1;

            while (true) {
                if (counter > 5) {
                    counter = 1;
                }
                int tmp = q.poll();
                tmp -= counter;
                if (tmp <= 0) {
                    q.add(0);
                    break;
                } else {
                    q.add(tmp);
                }
                counter++;
            }

            bw.write("#" + t + " ");
            while (!q.isEmpty()) {
                bw.write(q.poll() + " ");
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}