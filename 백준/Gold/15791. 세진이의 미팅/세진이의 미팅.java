import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, r;
    static long ans;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());


        // nCr = n! / r! * (n-r)!
        // 페르마의 소정리 : a**p = a (mod p)
        // p가 소수일때 => a**(p-1) = 1 (mod p)
        // 변형 => a ** (p-2) = (1/a) (mod p)
        // nCr = n! * (r! * (n-r)!)**(p-2) (mod p)
        ans = (factorial(n) * power((factorial(r) * factorial(n - r)) % MOD, MOD - 2)) % MOD;

        System.out.println(ans);

        br.close();
    }

    static long power(long x, int y) {
        if (y == 1) return x;

        long ans = power(x, y / 2);
        if (y % 2 == 0) {
            return (ans * ans) % MOD;
        } else {
            return (((ans * ans) % MOD) * x) % MOD;
        }
    }

    static long factorial(int x) {
        long answer = 1;
        for (int i = 2; i <= x; i++) {
            answer = (answer * i) % MOD;
        }
        return answer;
    }


}