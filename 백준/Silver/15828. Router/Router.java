import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static Queue<Integer> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        q = new ArrayDeque<>();

        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == -1) break;

            if (input == 0) {
                q.poll();
            } else {
                if (q.size() < n) {
                    q.add(input);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (q.isEmpty()) {
            sb.append("empty");
        } else {
            while (!q.isEmpty()) {
                sb.append(q.poll()).append(' ');
            }
        }

        System.out.println(sb);

        br.close();
    }

}
