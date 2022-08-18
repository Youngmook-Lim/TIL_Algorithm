import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int k;
    static int i;
    static Queue<Integer> q;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int x = q.poll();
                q.offer(x);
            }
            sb.append(q.poll()).append(q.size() == 0 ? ">" : ", ");
        }

        bw.write(sb.toString() + "\n");


        bw.flush();
        bw.close();
        br.close();

    }

}
