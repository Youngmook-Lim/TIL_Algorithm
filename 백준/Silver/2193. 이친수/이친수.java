import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static long[] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        memo = new long[n + 1];

        System.out.println(getPinary(n));

        br.close();
    }

    static long getPinary(int num) {
        if (num <= 2) {
            memo[num] = 1;
            return memo[num];
        }

        if (memo[num] != 0) {
            return memo[num];
        }

        return memo[num] = getPinary(num - 1) + getPinary(num - 2);
    }


}


