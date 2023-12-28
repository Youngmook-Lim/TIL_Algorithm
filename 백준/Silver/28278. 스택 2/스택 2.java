import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static Stack<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        q = new Stack<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            switch (input) {
                case "1":
                    int num = Integer.parseInt(st.nextToken());
                    q.push(num);
                    break;
                case "2":
                    sb.append((q.isEmpty()) ? -1 : q.pop()).append('\n');
                    break;
                case "3":
                    sb.append(q.size()).append('\n');
                    break;
                case "4":
                    sb.append((q.isEmpty()) ? 1 : 0).append('\n');
                    break;
                case "5":
                    sb.append((q.isEmpty()) ? -1 : q.peek()).append('\n');
            }
        }

        System.out.println(sb);

        br.close();
    }


}

