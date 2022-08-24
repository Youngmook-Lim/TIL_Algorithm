import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int[][] graph;
    static String[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            graph = new int[n][n];
            ans = new String[n];
            for (int i = 0; i < n; i++) {
                ans[i] = "";
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            turn(90);
            turn(180);
            turn(270);

            bw.write("#" + t + "\n");
            for (String x : ans) {
                bw.write(x + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void turn(int degree) {
        switch (degree) {
            case 90:
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j >= 0; j--) {
                        ans[i] += graph[j][i];
                    }
                    ans[i] += " ";
                }
                break;

            case 180:
                for (int i = n - 1; i >= 0; i--) {
                    for (int j = n - 1; j >= 0; j--) {
                        ans[n - i - 1] += graph[i][j];
                    }
                    ans[n - i - 1] += " ";
                }
                break;

            case 270:
                for (int i = n - 1; i >= 0; i--) {
                    for (int j = 0; j < n; j++) {
                        ans[n - i - 1] += graph[j][i];
                    }
                    ans[n - i - 1] += " ";
                }
                break;
        }
    }
}
