import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String claps = br.readLine();
            int curClaps = 0;
            int additional = 0;

            for (int i = 0; i < claps.length(); i++) {
                if (i <= curClaps) {
                    curClaps += claps.charAt(i) - '0';
                } else {
                    while (curClaps != i) {
                        curClaps++;
                        additional++;
                    }
                    curClaps += claps.charAt(i) - '0';
                }
            }
            bw.write("#" + t + " " + additional + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
