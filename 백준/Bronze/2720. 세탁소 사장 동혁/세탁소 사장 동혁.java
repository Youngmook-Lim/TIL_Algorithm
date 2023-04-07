import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int[] coins = {25, 10, 5, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());

            for (int j = 0; j < 4; j++) {
                int numOfCoins = num / coins[j];
                int total = numOfCoins * coins[j];
                sb.append(numOfCoins).append(' ');

                num -= total;
            }
            sb.append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}

