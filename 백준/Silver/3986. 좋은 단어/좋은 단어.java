import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < word.length(); j++) {
                char cur = word.charAt(j);
                if (!stack.isEmpty() && stack.peek() == cur) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }
            if (stack.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);

        br.close();
    }

}


