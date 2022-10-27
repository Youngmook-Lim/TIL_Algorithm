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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        str = br.readLine();
        bomb = br.readLine();
        bombLen = bomb.length();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() >= bombLen) {
                flag = true;
                for (int j = 0; j < bombLen; j++) {
                    if (bomb.charAt(j) != sb.charAt(sb.length() - bombLen + j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    sb.delete(sb.length() - bombLen, sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            sb.append("FRULA");
        }

        System.out.println(sb);

        br.close();
    }


}

