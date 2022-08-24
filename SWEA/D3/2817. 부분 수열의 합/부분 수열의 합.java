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

	// idx번째 원소를 고르는 경우와 안고르는 경우로 확장
	static void powerSet(int idx) {
		// 부분집합이 다 골라짐
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				// check된 숫자를 더한다.
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
