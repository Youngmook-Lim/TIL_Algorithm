import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String sticksAndLasers = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int cnt = 0;

        for (int i = 0; i < sticksAndLasers.length(); i++) {
            char cur = sticksAndLasers.charAt(i);
            if (cur == '(') {
                if (sticksAndLasers.charAt(i + 1) == ')') {
                    ans += cnt;
                    i++;
                } else {
                    stack.push(cur);
                    cnt++;
                }
            } else {
                stack.pop();
                ans++;
                cnt--;
            }
        }

        System.out.println(ans);

        br.close();
    }


}

