import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i < n) {
                for (int j = 0; j < n - i; j++) {
                    sb.append(' ');
                }
                sb.append('*');

                if (i > 1) {
                    for (int j = 0; j < (i - 1) * 2 - 1; j++) {
                        sb.append(' ');
                    }
                    sb.append('*');
                }
                sb.append('\n');
            } else {
                for (int j = 0; j < n * 2 - 1; j++) {
                    sb.append('*');
                }
            }
        }

        System.out.println(sb);

        br.close();
    }


}
