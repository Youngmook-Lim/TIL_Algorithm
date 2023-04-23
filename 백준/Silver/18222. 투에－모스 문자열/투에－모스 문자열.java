import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static long k, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Long.parseLong(br.readLine());
        n = 1L;

        while (n < k) {
            n *= 2;
        }

        char res = getChar(n, k);

        System.out.println(res);

        br.close();
    }

    static char getChar(long num, long target) {
        if (target == 1) {
            return '0';
        }
        long newTarget = target - num / 2;
        while (num >= newTarget) {
            num /= 2;
        }
        num *= 2;
        return (getChar(num, newTarget) == '0' ? '1' : '0');
    }


}
