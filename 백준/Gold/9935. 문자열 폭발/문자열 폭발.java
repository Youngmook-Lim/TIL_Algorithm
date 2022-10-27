import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    static int bombLen;
    static String str, bomb;
    static boolean flag;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        str = br.readLine();
        bomb = br.readLine();
        bombLen = bomb.length();

        stack = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            stack.push(str.charAt(i));

            if (stack.size() >= bombLen) {
                flag = true;
                for (int j = 0; j < bombLen; j++) {
                    if (bomb.charAt(j) != stack.get(stack.size() - j - 1)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            sb.append("FRULA");
        } else {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
        }

        System.out.println(sb);

        br.close();
    }


}

