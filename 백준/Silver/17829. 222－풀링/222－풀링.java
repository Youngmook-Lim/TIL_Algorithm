import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = divideAndConquer(0, 0, N);

        System.out.println(ans);

        br.close();

    }

    static int divideAndConquer(int xStart, int yStart, int n) {
        if (n == 1) {
            return graph[yStart][xStart];
        }

        int mid = n / 2;

        int[] tmp = new int[4];
        for (int i = 0; i < 4; i++) {
            int row = i / 2;
            int col = i % 2;
            tmp[i] = divideAndConquer(xStart + col * mid, yStart + row * mid, mid);
        }
        Arrays.sort(tmp);

        return tmp[2];
    }

}