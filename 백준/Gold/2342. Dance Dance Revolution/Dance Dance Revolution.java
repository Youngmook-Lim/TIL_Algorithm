import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static int[] arr;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] input = br.readLine().split(" ");
        n = input.length - 1;
        arr = new int[n];
        dp = new int[n][5][5];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        ans = dfs(0, 0, 0);

        System.out.println(ans);

        br.close();
    }

    static int dfs(int idx, int left, int right) {
        if (idx == n) {
            return 0;
        }

        if (dp[idx][left][right] != 0) {
            return dp[idx][left][right];
        }

        int step = arr[idx];

        int leftCost = getCost(left, step) + dfs(idx + 1, step, right);
        int rightCost = getCost(right, step) + dfs(idx + 1, left, step);

        return dp[idx][left][right] = Math.min(leftCost, rightCost);


    }

    static int getCost(int base, int target) {
        if (base == target) {
            return 1;
        }
        if (base == 0) {
            return 2;
        }
        if (Math.abs(base - target) == 2) {
            return 4;
        }
        return 3;
    }


}

