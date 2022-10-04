import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double ans;
        String input = br.readLine();
        Stack<Double> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put((char) (i + 65), Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < input.length(); i++) {
            char value = input.charAt(i);
            if (Character.isAlphabetic(value)) {
                stack.push((double) map.get(value));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (value) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }

        ans = stack.pop();
        System.out.println(String.format("%.2f", ans));

        br.close();
    }

}

