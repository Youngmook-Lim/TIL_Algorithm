import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		while (queue.size() != 1) {
			sb.append(queue.poll()).append(' ');
			queue.add(queue.poll());
		}

		sb.append(queue.peek());

		System.out.println(sb);

	}
}
