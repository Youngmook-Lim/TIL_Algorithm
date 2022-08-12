import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] paper;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int cnt;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        paper = new int[100][100];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int k = y; k < y + 10; k++) {
                for (int j = x; j < x + 10; j++) {
                    if (paper[k][j] == 0) {
                        paper[k][j]++;
                        cnt++;
                    }
                }
            }
        }


        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {
                            if (paper[ny][nx] == 0) {
                                total++;

                            }
                        } else {
                            total++;
                        }
                    }
                }
            }
        }

        bw.write(total + "\n");

        bw.flush();
        bw.close();
        br.close();

    }


}

