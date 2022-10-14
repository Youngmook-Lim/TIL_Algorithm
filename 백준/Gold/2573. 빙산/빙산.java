import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*---아래 코드 time 증가시켜가며 수행---
 * 3. 배열 copy떠서 for문 돌려서  0아닌 값 나올때 BFS, BFS 두번 돌려야 되면 정답
 * 1. graph배열과 4방에 0이 몇개인지 저장하는 배열 세팅
 * 2. for문 돌면서 0이 아닌 값에 대해서 얼마나 감소할지 확인한 후에 값 감소시킴
 */

public class Main {

	static int n, m, year;
	static int[][] graph, howMany;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class P {
		int x, y;

		public P(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			if (checkBfs()) {
				break;
			}
			howMany = new int[n][m];
			if (setHowMany()) {
                year = 0;
				break;
			}
			melt();
			year++;
		}

		System.out.println(year);

		br.close();
	}

	static void melt() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] != 0) {
					graph[i][j] = Math.max(0, graph[i][j] - howMany[i][j]);
				}
			}
		}
	}

	static boolean setHowMany() {
		int total = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] != 0) {
					total++;
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int ni = i + dy[k];
						int nj = j + dx[k];

						if (ni < 0 || ni >= n || nj < 0 || nj >= m || graph[ni][nj] != 0)
							continue;
						cnt++;
					}
					howMany[i][j] = cnt;
				}
			}
		}
		return total == 0;
	}

	static boolean checkBfs() {
		visited = new boolean[n][m];

		boolean flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] != 0 && !visited[i][j]) {
					if (!flag) {
						flag = bfs(i, j);
					} else {
						return true;
					}
				}
			}
		}
		return false;
	}

	static boolean bfs(int y, int x) {
		Queue<P> q = new ArrayDeque<>();
		q.add(new P(x, y));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			P p = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];

				if (nx < 0 || nx >= m || ny < 0 || ny >= n || graph[ny][nx] == 0 || visited[ny][nx])
					continue;

				visited[ny][nx] = true;
				q.add(new P(nx, ny));
			}
		}

		return true;

	}

}