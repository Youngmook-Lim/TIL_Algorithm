import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            int card = n - i;
            int cmd = arr[i];

            if (cmd == 1) {
                deque.addFirst(card);
            } else if (cmd == 2) {
                int tmp = deque.pollFirst();
                deque.addFirst(card);
                deque.addFirst(tmp);
            } else {
                deque.addLast(card);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : deque) {
            sb.append(x).append(' ');
        }

        System.out.println(sb);

        br.close();
    }

}


