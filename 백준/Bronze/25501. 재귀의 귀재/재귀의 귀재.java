import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            cnt = 0;
            String s = br.readLine();
            int isPalindrome = check(s, 0, s.length() - 1);
            bw.write(isPalindrome + " " + cnt + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    static int check(String s, int l, int r) {
        cnt++;

        if (l >= r) {
            return 1;
        } else if (s.charAt(l) != s.charAt(r)) {
            return 0;
        } else {
            return check(s, l + 1, r - 1);
        }

    }


}