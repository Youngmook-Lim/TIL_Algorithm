import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static char[][] graph;
    static int n, m;
    static int area;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char cur = graph[i][j];
                int x = m - j - 1;
                int y = n - i - 1;
                int k = Math.min(x, y);

                for (int l = k; l >= 0; l--) {
                    int right = graph[i][j + l];
                    int left = graph[i + l][j];
                    int dia = graph[i + l][j + l];
                    if (right == cur && left == cur && dia == cur) {
                        area = Math.max(area, (l + 1) * (l + 1));
                        break;
                    }
                }
            }
        }

        System.out.println(area);

        br.close();
    }


}
