import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
        int T = 10;
        for (int t = 1; t <= T; t++) {
            int tt = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 8; i++) {
                stack.push(Integer.parseInt(st.nextToken()));
            }

            int counter = 1;
            while (true) {
                if (counter > 5) {
                    counter = 1;
                }
                int tmp = stack.remove(0);
                tmp -= counter;
                if (tmp <= 0) {
                    stack.push(0);
                    break;
                } else {
                    stack.push(tmp);
                }
                counter++;
            }
            
            System.out.print("#" + t + " ");
            for (int i = 0; i < stack.size(); i++) {
                System.out.print(stack.get(i) + " ");
            }
            System.out.println();

        }

        br.close();
    }

}