import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = 0;
        int cur = 0;


        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int off = Integer.parseInt(st.nextToken());
            int on = Integer.parseInt(st.nextToken());

            cur += (on - off);

            max = Math.max(max, cur);

        }

        System.out.println(max);

        br.close();
    }


}
