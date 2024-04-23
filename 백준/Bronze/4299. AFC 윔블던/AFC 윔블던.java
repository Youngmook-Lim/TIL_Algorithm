import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= total / 2; i++) {
            int a = total - i;
            int b = i;
            if (Math.abs(a - b) == diff) {
                System.out.println(a + " " + b);
                return;
            }
        }

        System.out.println(-1);

        br.close();
    }


}


