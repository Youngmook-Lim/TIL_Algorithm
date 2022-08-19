import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int t = 1; t <= 10; t++) {
            int _ = Integer.parseInt(br.readLine());
            table = new int[100][100];
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int total = 0;

            for (int i = 0; i < 100; i++) {
                int cnt = 0;
                for (int j = 0; j < 100; j++) {
                    if (table[j][i] == 1) {
                        for (int k = j; k < 100; k++) {
                            if (table[k][i] == 2) {
                                cnt++;
                                break;
                            } else if (table[k][i] == 1 && k != j) {
                                break;
                            }
                        }
                    } else if (table[j][i] == 2) {
                        for (int k = j; k >= 0; k--) {
                            if (table[k][i] == 1) {
                                cnt++;
                                break;
                            } else if (table[k][i] == 2 && k != j) {
                                break;
                            }
                        }
                    }
                }
                total += cnt / 2;
            }

            bw.write("#" + t + " " + total + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}