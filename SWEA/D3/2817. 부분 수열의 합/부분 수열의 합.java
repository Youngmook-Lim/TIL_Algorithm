import java.util.Scanner;

public class Solution {
	static int N, K;
	static boolean[] check;
	static int[] arr;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			check = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			ans = 0;
			powerSet(0);
			System.out.println("#" + t + " " + ans);
		}

	}

	static void powerSet(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (check[i]) {
					sum += arr[i];
				}
			}
			if (sum == K) {
				ans++;
			}
			return;
		}

		check[idx] = true;
		powerSet(idx + 1);
		check[idx] = false;
		powerSet(idx + 1);
	}
}
