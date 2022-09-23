import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n;

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            long ans = power(2, n - 2);
            System.out.println(ans);
        }

        br.close();
    }

    static long power(long a, int p) {
        long ret = 1;
        while (p > 0) {
            if (p % 2 == 1) {
                ret = (ret * a) % MOD;
            }
            a = (a * a) % MOD;
            p /= 2;
        }
        return ret;
    }


}