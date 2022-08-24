import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] bus = new int[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                bus[i][0] = Integer.parseInt(st.nextToken());
                bus[i][1] = Integer.parseInt(st.nextToken());
            }

            int p = Integer.parseInt(br.readLine());
            int[] stops = new int[p];
            for (int i = 0; i < p; i++) {
                stops[i] = Integer.parseInt(br.readLine());
            }

            bw.write("#" + t + " ");
            for (int i = 0; i < p; i++) {
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (stops[i] >= bus[k][0] && stops[i] <= bus[k][1]) {
                        cnt++;
                    }
                }
                bw.write(cnt + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
