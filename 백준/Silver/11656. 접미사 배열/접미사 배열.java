import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<String> pq = new PriorityQueue<>();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            pq.add(str.substring(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}
