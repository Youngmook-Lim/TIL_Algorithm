import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append('*');
                if (j == (n + 1) / 2) {
                    sb.append('\n');
                }
                sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}
