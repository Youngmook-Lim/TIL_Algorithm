import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static String input;
    static Stack<P> initializeStack;
    static List<P> list;
    static boolean[] check;
    static TreeSet<String> ans;

    static class P {
        int start, end;

        public P(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        input = br.readLine();
        int inputLength = input.length();
        initializeStack = new Stack<>();
        list = new ArrayList<>();
        ans = new TreeSet<>();

        for (int i = 0; i < inputLength; i++) {
            if (input.charAt(i) == '(') {
                initializeStack.push(new P(i, -1));
            } else if (input.charAt(i) == ')') {
                P tmp = initializeStack.pop();
                tmp.end = i;
                list.add(tmp);
            }
        }

        int size = list.size();

        for (int i = (1 << size) - 2; i >= 0; i--) {
            check = new boolean[inputLength];
            for (int j = 0; j < size; j++) {
                if ((i & (1 << j)) == 0) {
                    check[list.get(j).start] = true;
                    check[list.get(j).end] = true;
                }
            }
            StringBuilder newString = new StringBuilder();
            for (int j = 0; j < inputLength; j++) {
                if (!check[j]) {
                    newString.append(input.charAt(j));
                }
            }
            ans.add(newString.toString());
        }

        for (String x : ans) {
            sb.append(x).append('\n');
        }
        System.out.println(sb);

        br.close();
    }

}

