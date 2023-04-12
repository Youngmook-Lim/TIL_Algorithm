import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();

        int n = 1;
        int idx = 0;

        while (true) {
            String nString = Integer.toString(n);

            for (int i = 0; i < nString.length(); i++) {
                char cur = nString.charAt(i);
                if (cur == input.charAt(idx)) {
                    idx++;
                }
                if (idx >= input.length()) {
                    System.out.println(n);
                    return;
                }
            }

            n++;
        }

//        br.close();
    }

}

