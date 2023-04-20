import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long gcd = getGcd(a, b);
        System.out.println(getLcm(gcd, a, b));

        br.close();
    }

    static long getLcm(long gcd, long a, long b) {
        return a * b / gcd;
    }

    static long getGcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }


}
