import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(" ".repeat(n - i - 1)).append("*");
            if (i > 0) {
                sb.append(" ".repeat(i * 2 - 1)).append("*");
            }
            sb.append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}


