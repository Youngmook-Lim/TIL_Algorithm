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
            sb.append("@".repeat(n * 5)).append('\n');
        }
        for (int i = 0; i < n * 3; i++) {
            sb.append("@".repeat(n)).append(" ".repeat(3 * n)).append("@".repeat(n)).append('\n');
        }
        for (int i = 0; i < n; i++) {
            sb.append("@".repeat(n * 5)).append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}

