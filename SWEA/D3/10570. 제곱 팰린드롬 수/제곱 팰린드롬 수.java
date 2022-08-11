import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int cnt = 0;

            for (int i = a; i < b + 1; i++) {
                int ii = (int) Math.sqrt(i);
                if (ii * ii == i) {
                    if (checkPalindrome(i) && (checkPalindrome(ii))) {
                        cnt++;
                    }
                }
            }

            System.out.println("#" + t + " " + cnt);
        }
        br.close();
    }

    static boolean checkPalindrome(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        String tmp = sb.toString();
        sb.reverse();
//        System.out.println(sb.toString() + " " + tmp);
        return sb.toString().equals(tmp);
    }
}