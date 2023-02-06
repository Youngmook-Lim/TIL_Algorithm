import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (Character.isDigit(cur) || cur == ' ') {
                sb.append(cur);
            } else {
                if (cur >= 'A' && cur <= 'Z') {
                    sb.append((char) ('A' + (cur + 13 - 'A') % 26));
                } else {
                    sb.append((char) ('a' + (cur + 13 - 'a') % 26));
                }
            }
        }

        System.out.println(sb);

        br.close();
    }


}














