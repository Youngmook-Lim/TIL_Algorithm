import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static char[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            System.arraycopy(arr, 0, graph[i], 0, n);
        }

        int cntX = 0;
        int cntY = 0;

        for (int i = 0; i < n; i++) {
            int tmpY = 0;
            int tmpX = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == '.') {
                    tmpX++;
                } else {
                    if (tmpX >= 2) {
                        cntX++;
                    }
                    tmpX = 0;
                }
                if (graph[j][i] == '.') {
                    tmpY++;
                } else {
                    if (tmpY >= 2) {
                        cntY++;
                    }
                    tmpY = 0;
                }
            }
            if (tmpX >= 2) {
                cntX++;
            }
            if (tmpY >= 2) {
                cntY++;
            }
        }

        System.out.println(cntX + " " + cntY);


        br.close();
    }


}
