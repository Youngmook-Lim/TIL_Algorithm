import java.util.Scanner;

public class Solution {

	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			arr = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int ans = check();

			System.out.println("#" + t + " " + ans);
		}
	}

	static int check() {
		// 모든 행에서 중복이 있는지 검사
		for (int i = 0; i < 9; i++) {
			boolean[] check = new boolean[10];
			for (int j = 0; j < 9; j++) {
				// 중복이 발견 되면 return 0
				if (check[arr[i][j]]) {
					return 0;
				}
				check[arr[i][j]] = true;
			}
		}

		for (int j = 0; j < 9; j++) {
			boolean[] check = new boolean[10];
			for (int i = 0; i < 9; i++) {
				// 중복이 발견 되면 return 0
				if (check[arr[i][j]]) {
					return 0;
				}
				check[arr[i][j]] = true;
			}
		}

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				// i, j가 각각 격자박스의 시작점
				boolean[] check = new boolean[10];
				for (int m = 0; m < 3; m++) {
					for (int n = 0; n < 3; n++) {
						if (check[arr[i + m][j + n]]) {
							return 0;
						}
						check[arr[i + m][j + n]] = true;
					}
				}
			}
		}
		return 1;
	}

}
