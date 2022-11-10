import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] graph;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str1 = br.readLine();
        String str2 = br.readLine();

        graph = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    graph[i][j] = graph[i - 1][j - 1] + 1;
                } else {
                    graph[i][j] = Math.max(graph[i - 1][j], graph[i][j - 1]);
                }
            }
        }

        int x = str2.length();
        int y = str1.length();
        ans = graph[y][x];

        if (ans == 0) {
            System.out.println(ans);
            return;
        }

        while (x > 0 && y > 0) {
            if (str1.charAt(y - 1) == str2.charAt(x - 1)) {
                sb.append(str1.charAt(y - 1));
                x--;
                y--;
            } else {
                if (graph[y][x - 1] > graph[y - 1][x]) {
                    x--;
                } else {
                    y--;
                }
            }
        }

        System.out.println(ans);
        System.out.println(sb.reverse());

        br.close();
    }

}

