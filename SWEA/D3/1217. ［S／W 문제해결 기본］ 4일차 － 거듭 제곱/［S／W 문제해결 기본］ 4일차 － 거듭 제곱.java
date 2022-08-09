

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int recursive(int n, int m) {
        if (m == 1) {
            return n;
        }

        return n * recursive(n, m - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
//        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int tt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int ans = recursive(n, m);

            System.out.println("#" + tt + " " + ans);

        }

        br.close();
    }
}