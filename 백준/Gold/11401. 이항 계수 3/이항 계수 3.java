import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long N, K, ans;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        ans = 0;

        int p = MOD - 2;
        long top = factorialMod(N);
        long bottom = ((factorialMod(K) % MOD) * (factorialMod(N - K) % MOD)) % MOD;
        bottom = power(bottom, p);
        ans = (top * bottom) % MOD;

        System.out.println(ans);


        br.close();
    }

    static long power(long n, int p) {
        if (p == 1) {
            return n;
        }

        long answer = power(n, p / 2) % MOD;

        if (p % 2 == 0) {
            return (answer * answer) % MOD;
        } else {
            return ((answer * answer) % MOD * n) % MOD;
        }
    }

    static long factorialMod(long n) {
        long product = 1;

        for (long i = n; i > 0; i--) {
            product = (product * i) % MOD;

        }
        return product;
    }

}