import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static char[][] mines, opened, result;
    static int n;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        mines = new char[n][n];
        opened = new char[n][n];
        result = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                mines[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                opened[i][j] = input.charAt(j);
            }
        }

        if (!check()) {
            markMines();
        }

        String out = getString(result);

        System.out.println(out);

        br.close();
    }

    static void markMines() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j] == '*') {
                    result[i][j] = '*';
                }
            }
        }
    }

    static String getString(char[][] graph) {
        StringBuilder sb = new StringBuilder();
        for (char[] arr : graph) {
            for (char x : arr) {
                sb.append(x);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    static boolean check() {
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char cur = opened[i][j];
                if (cur == '.') {
                    result[i][j] = '.';
                } else {
                    if (mines[i][j] == '*') {
                        result[i][j] = '*';
                        flag = false;
                    }
                    int cnt = getMines(j, i);
                    result[i][j] = (char) (cnt + '0');
                }
            }
        }

        return flag;
    }

    static int getMines(int x, int y) {
        int cnt = 0;
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (mines[ny][nx] == '*') cnt++;
        }
        return cnt;
    }


}

