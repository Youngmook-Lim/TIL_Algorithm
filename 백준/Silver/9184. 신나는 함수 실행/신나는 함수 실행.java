import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[][][] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        memo = new int[101][101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                Arrays.fill(memo[i][j], Integer.MAX_VALUE);
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


            if (a == -1 && b == -1 && c == -1) break;

            System.out.printf("w(%d, %d, %d) = ", a, b, c);
            System.out.println(w(a, b, c));
        }

        br.close();

    }

    static int w(int a, int b, int c) {
        if (memo[a + 50][b + 50][c + 50] != Integer.MAX_VALUE) {
            return memo[a + 50][b + 50][c + 50];
        } else {
            if (a <= 0 || b <= 0 || c <= 0) {
                memo[a + 50][b + 50][c + 50] = 1;
                return memo[a + 50][b + 50][c + 50];
            }
            if (a > 20 || b > 20 || c > 20) {
                memo[a + 50][b + 50][c + 50] = w(20, 20, 20);
                return memo[a + 50][b + 50][c + 50];
            }
            if (a < b && b < c) {
                memo[a + 50][b + 50][c + 50] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
                return memo[a + 50][b + 50][c + 50];
            }
            memo[a + 50][b + 50][c + 50] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
            return memo[a + 50][b + 50][c + 50];
        }
    }


}