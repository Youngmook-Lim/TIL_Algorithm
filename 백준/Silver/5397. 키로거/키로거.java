import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static int t;
    static char[] keylog;
    static List<Character> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            keylog = br.readLine().toCharArray();
            list = new LinkedList<>();
            int idx = 0;

            for (int j = 0; j < keylog.length; j++) {
                char x = keylog[j];
                if (x == '<') {
                    if (idx > 0) {
                        idx--;
                    }
                } else if (x == '>') {
                    if (idx < list.size()) {
                        idx++;
                    }
                } else if (x == '-') {
                    if (idx > 0) {
                        list.remove(idx-- - 1);
                    }
                } else {
                    list.add(idx++, x);
                }
            }

            sb = new StringBuilder();
            for (char x : list) {
                sb.append(x);
            }
            bw.write(sb + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
