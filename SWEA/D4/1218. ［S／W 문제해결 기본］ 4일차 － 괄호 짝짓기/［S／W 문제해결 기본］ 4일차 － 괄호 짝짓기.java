import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            Stack<Character> stack = new Stack<>();

            int n = Integer.parseInt(br.readLine());

            String parentheses = br.readLine();

            for (int i = 0; i < n; i++) {
                char x = parentheses.charAt(i);

                if (x == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(x);
                    }
                } else if (x == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(x);
                    }
                } else if (x == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(x);
                    }
                } else if (x == '>') {
                    if (stack.peek() == '<') {
                        stack.pop();
                    } else {
                        stack.push(x);
                    }
                } else {
                    stack.push(x);
                }
            }
            int ans = (stack.size() == 0) ? 1 : 0;
            bw.write("#" + t + " " + ans + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}