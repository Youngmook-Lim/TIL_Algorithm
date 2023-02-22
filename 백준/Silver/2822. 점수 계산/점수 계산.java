import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < 8; i++) {
            map.put(-Integer.parseInt(br.readLine()), i + 1);
        }

        int sum = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (Integer x : map.keySet()) {
            sum += x;
            pq.add(map.get(x));
            if (pq.size() == 5) break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(-sum).append('\n');
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(' ');
        }
        System.out.println(sb);

        br.close();
    }


}


