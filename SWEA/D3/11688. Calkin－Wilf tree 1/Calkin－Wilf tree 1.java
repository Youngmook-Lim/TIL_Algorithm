
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            int a = 1;
            int b = 1;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'L') {
                    b += a;
                } else {
                    a += b;
                }
            }

            System.out.println("#" + t + " " + a + " " + b);

        }

        br.close();
    }

}