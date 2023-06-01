import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int total = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int score = Integer.parseInt(br.readLine());
            min = Math.min(min, score);
            total += score;
        }

        total -= min;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 2; i++) {
            int score = Integer.parseInt(br.readLine());
            max = Math.max(max, score);
        }

        total += max;

        System.out.println(total);

        br.close();
    }


}
