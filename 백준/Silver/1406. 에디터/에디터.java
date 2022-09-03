import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static String word;
    static int n, m;
    static Stack<Character> stackOrg, stackTmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        stackOrg = new Stack<>();
        stackTmp = new Stack<>();

        word = br.readLine();
        n = word.length();
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            stackOrg.push(word.charAt(i));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            char insert = '0';
            if (cmd == 'P') {
                insert = st.nextToken().charAt(0);
            }

            switch (cmd) {
                case 'L':
                    if (!stackOrg.isEmpty()) {
                        stackTmp.push(stackOrg.pop());
                    }
                    break;
                case 'D':
                    if (!stackTmp.isEmpty()) {
                        stackOrg.push(stackTmp.pop());
                    }
                    break;
                case 'B':
                    if (!stackOrg.isEmpty()) {
                        stackOrg.pop();
                    }
                    break;
                case 'P':
                    stackOrg.push(insert);
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();

        while (!stackOrg.isEmpty()) {
            sb.append(stackOrg.pop());
        }
        sb.reverse();
        while (!stackTmp.isEmpty()) {
            sb.append(stackTmp.pop());
        }

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}