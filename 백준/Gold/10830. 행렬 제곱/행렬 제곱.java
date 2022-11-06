import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static final int MOD = 1000;
    static int n;
    static long b;
    static int[][] orgMatrix, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());
        orgMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                orgMatrix[i][j] = Integer.parseInt(st.nextToken());
                if (orgMatrix[i][j] == 1000) {
                    orgMatrix[i][j] = 0;
                }
            }
        }

        ans = getPower(b);

        for (int[] x : ans) {
            for (int y : x) {
                sb.append(y).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    static int[][] getPower(long pow) {
        if (pow == 1) {
            return orgMatrix;
        }

        long mid = pow / 2;
        int[][] result = getPower(mid);

        if (pow % 2 == 0) {
            return multiplyMatrix(result, result);
        } else {
            return multiplyMatrix(multiplyMatrix(result, result), orgMatrix);
        }
    }

    static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
                result[i][j] %= MOD;
            }
        }

        return result;
    }


}

