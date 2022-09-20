import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long N;
    static long MOD = 1000000007;
    static long[][] original = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        long[][] ans = getSolution(N - 1);

        System.out.println(ans[0][0]);
        br.close();
    }

    static long[][] getSolution(long n) {
//        System.out.println(Arrays.deepToString(matrix));
        if (n == 0 || n == 1) {
            return original;
        }

        long[][] tmp = getSolution(n / 2);

        tmp = multiply(tmp, tmp);

        if (n % 2 == 1) {
            tmp = multiply(tmp, original);
        }

        return tmp;

    }

    static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] tmp = new long[2][2];

        tmp[0][0] = (o1[0][0] * o2[0][0] + o1[0][1] * o2[1][0]) % MOD;
        tmp[0][1] = (o1[0][0] * o2[0][1] + o1[0][1] * o2[1][1]) % MOD;
        tmp[1][0] = (o1[1][0] * o2[0][0] + o1[1][1] * o2[1][0]) % MOD;
        tmp[1][1] = (o1[1][0] * o2[0][1] + o1[1][1] * o2[1][1]) % MOD;

        return tmp;
    }

}