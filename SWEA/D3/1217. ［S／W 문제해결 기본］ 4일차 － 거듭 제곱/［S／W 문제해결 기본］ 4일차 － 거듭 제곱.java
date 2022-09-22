import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;

        for (int t = 1; t <= T; t++) {
            int tc = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            System.out.println("#" + t + " " + calculate(n, m));
        }

        br.close();
    }

    static int calculate(int a, int b) {

        if (b == 1) {
            return a;
        }

        int result = calculate(a, b / 2);

        if (b % 2 == 0) {
            return result * result;
        } else {
            return result * result * a;
        }
    }

}