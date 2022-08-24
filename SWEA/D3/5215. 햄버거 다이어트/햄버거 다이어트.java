import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int n, l, maxPoints;
	static boolean[] check;
	static int[][] ingredients;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			check = new boolean[n];
			ingredients = new int[n][2];
			maxPoints = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = Integer.parseInt(st.nextToken());
				ingredients[i][1] = Integer.parseInt(st.nextToken());
			}

			solve(0, 0, 0);

			bw.write("#" + t + " " + maxPoints + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static void solve(int idx, int tSum, int kSum) {
		if (kSum > l)
			return;
		if (idx == n) {
			if (kSum <= l) {
				maxPoints = Math.max(maxPoints, tSum);
			}
			return;
		}

		solve(idx + 1, tSum + ingredients[idx][0], kSum + ingredients[idx][1]);
		solve(idx + 1, tSum, kSum);
	}
}
