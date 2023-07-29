import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] distance = new int[n - 1];
        int[] price = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int min = price[0];
        int total = price[0] * distance[0];

        for (int i = 1; i < n - 1; i++) {
            if (min > price[i]) {
                min = price[i];
            }
            total += min * distance[i];
        }

        System.out.println(total);


        br.close();
    }
}