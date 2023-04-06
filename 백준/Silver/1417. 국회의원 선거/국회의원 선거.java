import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int dasom = Integer.parseInt(br.readLine());
        int cnt = 0;

        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n - 1; i++) {
            pq.add(-Integer.parseInt(br.readLine()));
        }

        while (!pq.isEmpty()) {
            int highest = -pq.poll();
            if (dasom > highest) break;
            dasom++;
            cnt++;
            pq.add(-(highest - 1));
        }

        System.out.println(cnt);

        br.close();
    }


}

