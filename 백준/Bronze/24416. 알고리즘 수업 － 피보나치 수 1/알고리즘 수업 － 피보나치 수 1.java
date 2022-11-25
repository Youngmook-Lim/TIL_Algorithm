import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static int cntRec, cntDp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        fibRec(n);
        fibDp(n);

        System.out.println(cntRec + " " + cntDp);
        br.close();

    }

    static int fibRec(int n) {
        if (n == 1 || n == 2) {
            cntRec++;
            return 1;
        }
        return fibRec(n - 1) + fibRec(n - 2);
    }

    static int fibDp(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            cntDp++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}