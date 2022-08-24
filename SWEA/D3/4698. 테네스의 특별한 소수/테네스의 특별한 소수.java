import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            String D = st.nextToken();
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int cnt = 0;

            boolean[] nums = new boolean[B + 1];
            nums[1] = true;

            for (int i = 2; i < Math.sqrt(B) + 1; i++) {
                if (nums[i]) {
                    continue;
                }
                int k = i * 2;
                while (k <= B) {
                    if (!nums[k]) {
                        nums[k] = true;
                    }
                    k += i;
                }
            }

            for (int i = A; i <= B; i++) {
                if (!nums[i]) {
                    String tmp = String.valueOf(i);
                    if (tmp.contains(D)) {
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
