import java.io.*;

public class Main {

    static char[] word;
    static int l;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        word = br.readLine().toCharArray();
        l = word.length;

        idx = 0;
        boolean flag = false;


        for (int i = 0; i < l; i++) {
            if (word[i] == '<') {
                bw.write(sb.reverse().toString());
                sb.setLength(0);
                flag = true;
            }

            if (flag) {
                bw.write(word[i]);
            } else {
                if (word[i] == ' ') {
                    bw.write(sb.reverse().toString());
                    bw.write(' ');
                    sb.setLength(0);
                } else {
                    sb.append(word[i]);
                }
            }

            if (word[i] == '>') {
                flag = false;
            }
        }
        bw.write(sb.reverse().toString());

        bw.flush();
        bw.close();
        br.close();
    }

}
