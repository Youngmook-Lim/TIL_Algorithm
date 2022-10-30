import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            String cur = Character.toString(input.charAt(i));
            if (cur.equals("(") || cur.equals("[")) {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    stack.push(cur);
                    break;
                } else {
                    int num = 0;
                    while (!stack.isEmpty() && checkIfNum()) {
                        num += Integer.parseInt(stack.pop());
                    }
                    if (stack.isEmpty()) {
                        stack.push(cur);
                        break;
                    }
                    if (num == 0) num = 1;
                    String top = stack.peek();
                    if (cur.equals(")") && top.equals("(")) {
                        stack.pop();
                        stack.push(Integer.toString(num * 2));
                    } else if (cur.equals("]") && top.equals("[")) {
                        stack.pop();
                        stack.push(Integer.toString(num * 3));
                    }
                }
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            if (!checkIfNum()) break;
            ans += Integer.parseInt(stack.pop());
        }

        if (stack.isEmpty()) {
            System.out.println(ans);
        } else {
            System.out.println(0);
        }

        br.close();
    }

    static boolean checkIfNum() {
        return !stack.peek().equals("(") && !stack.peek().equals("[") && !stack.peek().equals("]") && !stack.peek().equals(")");
    }


}

