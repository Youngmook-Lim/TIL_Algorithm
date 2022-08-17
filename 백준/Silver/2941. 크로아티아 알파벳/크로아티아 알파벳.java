import java.io.*;

public class Main {

    static String word;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);

            switch (x) {
                case 'c':
                    if (i < word.length() - 1) {
                        if (word.charAt(i + 1) == '-' || word.charAt(i + 1) == '=') {
                            i++;
                        }
                    }
                    break;
                case 'l':
                case 'n':
                    if (i < word.length() - 1) {
                        if (word.charAt(i + 1) == 'j') {
                            i++;
                        }
                    }
                    break;
                case 's':
                case 'z':
                    if (i < word.length() - 1) {
                        if (word.charAt(i + 1) == '=') {
                            i++;
                        }
                    }
                    break;
                case 'd':
                    if (i < word.length() - 2) {
                        if (word.charAt(i + 1) == 'z' && word.charAt(i + 2) == '=') {
                            i += 2;
                        } else if (word.charAt(i + 1) == '-') {
                            i++;
                        }
                    } else if (i < word.length() - 1) {
                        if (word.charAt(i + 1) == '-') {
                            i++;
                        }
                    }
                    break;
            }
            cnt++;

        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

}

