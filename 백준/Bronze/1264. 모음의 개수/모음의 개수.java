import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

    static Set<Character> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        while (true) {
            String input = br.readLine();
            if (input.equals("#")) break;

            int cnt = 0;
            for (int i = 0; i < input.length(); i++) {
                if (set.contains(input.charAt(i))) cnt++;
            }
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);


        br.close();
    }

}














