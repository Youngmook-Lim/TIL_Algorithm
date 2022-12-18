import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int T;
    static long n;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Long.parseLong(br.readLine());
            BigInteger bigN = new BigInteger(String.valueOf(n));
            if (bigN.isProbablePrime(10)) {
                sb.append(bigN).append('\n');
            } else {
                sb.append(bigN.nextProbablePrime()).append('\n');
            }
        }
        System.out.println(sb);

        br.close();
    }


}
