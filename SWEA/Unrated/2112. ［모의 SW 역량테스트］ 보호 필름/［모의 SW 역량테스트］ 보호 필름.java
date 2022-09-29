import java.io.*;
import java.util.*;

public class Solution {

    static boolean finalFlag;
    static int d, w, k, drug, ans;
    static int[][] graph;
    static int[] combi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            drug = 0;
            ans = 0;
            finalFlag = false;
            graph = new int[d][w];
            combi = new int[d];
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            while (drug <= d) {
                if (finalFlag) break;
                dfs(0, 0);
                drug++;
            }

            sb.append("#" + t + " " + ans + "\n");

        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int idx, int depth) {
        if (finalFlag) return;
        if (depth == drug) {
            check();
            return;
        }

        for (int i = idx; i < d; i++) {
            combi[i] = 1;
            dfs(i + 1, depth + 1);
            combi[i] = 2;
            dfs(i + 1, depth + 1);
            combi[i] = 0;
        }
    }


    static void check() {
        for (int j = 0; j < w; j++) {
            int cntZero = 0;
            int cntOne = 0;
            boolean flag = false;

            for (int i = 0; i < d; i++) {
                if (combi[i] == 2) {
                    cntOne++;
                    cntZero = 0;
                } else if (combi[i] == 1) {
                    cntZero++;
                    cntOne = 0;
                } else if (graph[i][j] == 1) {
                    cntOne++;
                    cntZero = 0;
                } else if (graph[i][j] == 0) {
                    cntZero++;
                    cntOne = 0;
                }
                if (cntOne == k || cntZero == k) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return;
            }
        }
        finalFlag = true;
        ans = drug;
    }


}