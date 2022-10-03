import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static Deque<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            switch (input) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    q.offer(num);
                    break;
                case "pop":
                    sb.append((q.isEmpty()) ? -1 : q.poll()).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    sb.append((q.isEmpty()) ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append((q.isEmpty()) ? -1 : q.getFirst()).append('\n');
                    break;
                case "back":
                    sb.append((q.isEmpty()) ? -1 : q.getLast()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
        
        br.close();
    }


}

