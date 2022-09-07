import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);
            String s = st.nextToken();
            String t = st.nextToken();

            int idx = 0;
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == s.charAt(idx)) {
                    idx++;
                }
                if (idx == s.length()) break;
            }

            System.out.println((idx == s.length()) ? "Yes" : "No");
        }

        br.close();
    }
}