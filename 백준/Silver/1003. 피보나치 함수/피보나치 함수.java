import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            memo = new int[n + 1];
            Arrays.fill(memo, -1);

            if (n == 0) {
                System.out.println(1 + " " + 0);
            } else {
                memo[0] = 0;
                memo[1] = 1;
                int ans = fibo(n);
                System.out.println(memo[n - 1] + " " + memo[n]);
            }
        }

        br.close();
    }

    static int fibo(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = fibo(n - 1) + fibo(n - 2);
        return memo[n];
    }


}
