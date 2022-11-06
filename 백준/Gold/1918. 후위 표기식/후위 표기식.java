import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    static String str;
    static Stack<Character> stack;
    static Map<Character, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        stack = new Stack<>();
        map = new HashMap<>();
        StringBuilder sb = new StringBuilder();


        map.put('(', 1);
        map.put('+', 2);
        map.put('-', 2);
        map.put('*', 3);
        map.put('/', 3);


        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);

            if (Character.isLetter(x)) {
                sb.append(x);
            } else {
                if (stack.isEmpty()) {
                    stack.push(x);
                } else {
                    if (x == ')') {
                        while (stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        stack.pop();
                    } else if (map.get(x) > map.get(stack.peek()) || x == '(') {
                        stack.push(x);
                    } else {
                        while (!stack.isEmpty() && map.get(x) <= map.get(stack.peek())) {
                            sb.append(stack.pop());
                        }
                        stack.push(x);
                    }
                }
            }

        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

        br.close();

    }
}