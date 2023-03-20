import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            if (a == b && b == c) {
                sb.append("Equilateral");
            } else {
                Queue<Integer> pq = new PriorityQueue<>();
                pq.add(a);
                pq.add(b);
                pq.add(c);

                if (pq.poll() + pq.poll() <= pq.poll()) {
                    sb.append("Invalid");
                } else if (a == b || b == c || c == a) {
                    sb.append("Isosceles");
                } else {
                    sb.append("Scalene");
                }
            }

            sb.append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}


