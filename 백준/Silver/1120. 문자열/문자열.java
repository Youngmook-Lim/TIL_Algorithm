import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String x = st.nextToken();
        String y = st.nextToken();
        int lenX = x.length();
        int lenY = y.length();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= lenY - lenX; i++) {
            int cnt = 0;
            for (int j = 0; j < lenX; j++) {
                if (x.charAt(j) != y.charAt(i + j)) {
                    cnt++;
                }
            }
            min = Math.min(min, cnt);
        }

        System.out.println(min);

        br.close();
    }


}
