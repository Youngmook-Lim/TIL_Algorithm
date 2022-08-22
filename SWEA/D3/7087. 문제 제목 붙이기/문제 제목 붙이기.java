import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
            }

            Arrays.sort(words);
            int curASCII = 65;

            for (int i = 0; i < n; i++) {
                if (words[i].charAt(0) != curASCII) {
                    curASCII--;
                    break;
                }
                if (i != n - 1 && words[i].charAt(0) != words[i + 1].charAt(0)) {
                    curASCII++;
                }
            }

            bw.write("#" + t + " " + (curASCII - 65 + 1) + "\n");
        }


        bw.flush();
        bw.close();
        br.close();

    }

}