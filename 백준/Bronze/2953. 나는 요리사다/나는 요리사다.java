import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = 0;
        int maxChef = 0;

        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            int total = 0;
            for (int j = 0; j < 4; j++) {
                total += Integer.parseInt(st.nextToken());
            }
            if (total > max) {
                max = total;
                maxChef = i;
            }
        }

        System.out.println(maxChef + " " + max);

        br.close();
    }


}
