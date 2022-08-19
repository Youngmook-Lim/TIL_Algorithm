import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            char[] ans = br.readLine().toCharArray();
            boolean flag = false;
            char current = '0';
            int cnt = 0;

            for (int i = 0; i < ans.length; i++) {
                if (!flag) {
                    if (ans[i] != current) {
                        flag = true;
                        current = (current == '1') ? '0' : '1';
                        cnt++;
                    }
                } else {
                    if (ans[i] != current) {
                        current = (current == '1') ? '0' : '1';
                        cnt++;
                    }
                }
            }

            bw.write("#" + t + " " + cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}