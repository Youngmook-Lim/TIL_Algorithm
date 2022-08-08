

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int ans;
            if (X > U) {
                ans = -1;
            } else if (X > L) {
                ans = 0;
            } else {
                ans = L - X;
            }

            System.out.println("#" + t + " " + ans);

        }
    }
}
