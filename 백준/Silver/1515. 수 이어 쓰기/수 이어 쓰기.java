import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static List<Character> str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();
        str = new ArrayList<>();

        int n = 1;

        while (true) {
            createString(n);
            int idx = 0;

            for (int i = 0; i < str.size(); i++) {
                char cur = str.get(i);
                if (cur == input.charAt(idx)) {
                    idx++;
                }
                if (idx == input.length()) break;
            }

            if (idx == input.length()) {
                break;
            }

            n++;
        }

        System.out.println(n);

        br.close();
    }

    static void createString(int n) {
        String nString = Integer.toString(n);
        for (int i = 0; i < nString.length(); i++) {
            str.add(nString.charAt(i));
        }
    }

}

