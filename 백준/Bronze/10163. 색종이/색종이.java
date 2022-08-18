import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[1001][1001];
        int[] sums = new int[101];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int distX = Integer.parseInt(st.nextToken());
            int distY = Integer.parseInt(st.nextToken());


            for (int j = x; j < x + distX; j++) {
                for (int k = y; k < y + distY; k++) {
                    if (graph[j][k] != 0) {
                        sums[graph[j][k]]--;
                    }
                    sums[i]++;
                    graph[j][k] = i;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(sums[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
