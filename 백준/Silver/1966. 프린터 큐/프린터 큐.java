import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<Integer> q = new LinkedList<>();
            int[] priority = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                q.add(tmp);
                priority[i] = tmp;
            }

            Arrays.sort(priority);
            int max = priority[n - 1];
            int cnt = 0;

            while (true) {
                if (q.peek() != max) {
                    q.add(q.poll());
                } else {
                    q.poll();
                    if (n > 1) {
                        max = priority[--n - 1];
                    }
                    cnt++;
                    if (m == 0) {
                        bw.write(cnt + "\n");
                        break;
                    }
                }

                if (m == 0) {
                    m = q.size() - 1;
                } else {
                    m--;
                }
                ;
            }

        }

        bw.flush();
        bw.close();
        br.close();

    }

}

