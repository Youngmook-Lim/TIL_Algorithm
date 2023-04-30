import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] paper;
    static int cnt = 0;

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

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();

    }


}

