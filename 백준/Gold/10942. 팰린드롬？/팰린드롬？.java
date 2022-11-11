import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        table = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (i == 0) {
                    table[i][j] = true;
                } else if (i == 1) {
                    if (arr[j] == arr[j + 1]) {
                        table[i][j] = true;
                    } else {
                        table[i][j] = false;
                    }
                } else {
                    if (table[i - 2][j + 1] && arr[j] == arr[j + i]) {
                        table[i][j] = true;
                    } else {
                        table[i][j] = false;
                    }
                }
            }
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            if (table[end - start][start]) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb);

        br.close();
    }

}

