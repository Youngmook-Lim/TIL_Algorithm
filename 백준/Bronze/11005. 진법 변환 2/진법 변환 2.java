import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int remainder = n % b;
            char x;
            if (remainder < 10) {
                x = (char) (remainder + '0');
            } else {
                x = (char) ('A' + (remainder - 10));
            }
            sb.append(x);
            n /= b;
        }

        System.out.println(sb.reverse());

        br.close();
    }

}
