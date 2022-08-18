import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() != 1) {
            q.poll();
            int x = q.poll();
            q.add(x);
        }

        bw.write(q.peek() + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

}

