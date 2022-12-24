import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String string = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (i != 0 && i % 10 == 0) {
                sb.append('\n');
            }
            sb.append(string.charAt(i));
        }

        System.out.println(sb);

        br.close();
    }

}
