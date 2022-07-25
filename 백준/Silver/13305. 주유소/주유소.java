import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] distance = new int[n];
        int[] price = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            distance[i] += distance[i - 1];
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long min = price[0];
        int idx = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            if (price[i] < min) {
                int totalDist = distance[i] - distance[idx];
                total += totalDist * min;
                min = price[i];
                idx = i;
            }
            if (i == n - 1) {
                int totalDist = distance[i] - distance[idx];
                total += totalDist * min;
            }
        }

        System.out.println(total);

        br.close();
    }
}
