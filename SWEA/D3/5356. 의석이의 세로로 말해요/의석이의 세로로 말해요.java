import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int maxLength = 0;
            String[] words = new String[5];
            for (int i = 0; i < 5; i++) {
                words[i] = br.readLine();
                maxLength = Math.max(maxLength, words[i].length());
            }

            for (int i = 0; i < 5; i++) {
                if (words[i].length() < maxLength) {
                    while (words[i].length() < maxLength) {
                        words[i] += "*";
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < maxLength; i++) {
                for (int j = 0; j < 5; j++) {
                    if (words[j].charAt(i) != '*') {
                        sb.append(words[j].charAt(i));
                    }
                }
            }
            bw.write("#" + t + " " + sb + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
