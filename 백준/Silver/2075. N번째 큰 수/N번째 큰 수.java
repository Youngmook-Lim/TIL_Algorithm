import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            } else {
                for (int j = 0; j < n; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp > pq.peek()) {
                        pq.poll();
                        pq.add(tmp);
                    }
                }
            }

        }
        
        System.out.println(pq.poll());

        br.close();
    }


}

