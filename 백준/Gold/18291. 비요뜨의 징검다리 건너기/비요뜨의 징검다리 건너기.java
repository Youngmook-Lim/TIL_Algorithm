import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            if (n == 1 || n == 2) {
                sb.append(1).append("\n");
            } else {
                long ans = power(2, n - 2);
                sb.append(ans).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }

    static long power(long a, int p) {
        if (p == 1) return a;

        long ans = power(a, p / 2);

        if (p % 2 == 0) {
            return (ans * ans) % MOD;
        } else {
            return ((ans * ans) % MOD * a) % MOD;
        }

    }


}