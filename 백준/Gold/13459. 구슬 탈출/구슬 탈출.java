import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] graph;
    static int flag;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = tmp.charAt(j);
            }
        }

        dfs(0);


        System.out.println(flag);

        br.close();
    }

    static void dfs(int depth) {
        if (flag == 1) return;
        if (depth == 10) {
            char[][] tmp = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tmp[i][j] = graph[i][j];
                }
            }

            for (int i = 0; i < 10; i++) {
                if (!check(list.get(i), tmp)) {
                    break;
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (depth > 0 && i == list.get(list.size() - 1)) continue;
            list.add(i);
            dfs(depth + 1);
            list.remove(list.size() - 1);
        }
    }

    static boolean check(int dir, char[][] arr) {
        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'B') {
                    bx = j;
                    by = i;
                } else if (arr[i][j] == 'R') {
                    rx = j;
                    ry = i;
                }
            }
        }
        boolean resultRed, resultBlue;

        if ((dir == 0 && ry < by) || (dir == 1 && rx > bx) || (dir == 2 && ry > by) || (dir == 3 && rx < bx)) {
            resultRed = roll(dir, arr, ry, rx);
            resultBlue = roll(dir, arr, by, bx);
        } else {
            resultBlue = roll(dir, arr, by, bx);
            resultRed = roll(dir, arr, ry, rx);
        }
        if (!resultRed && resultBlue) {
            flag = 1;
            return false;
        } else if (resultRed && resultBlue) {
            return true;
        } else {
            return false;
        }

    }


    static boolean roll(int dir, char[][] arr, int y, int x) {
//        System.out.println(dir);
//        print(arr);
        char tmp = arr[y][x];
        arr[y][x] = '.';
        switch (dir) {
            case 0:
                while (true) {
                    y--;
                    if (arr[y][x] != '.') {
                        if (arr[y][x] == 'O') {
                            return false;
                        }
                        y++;
                        break;
                    }
                }
                break;
            case 1:
                while (true) {
                    x++;
                    if (arr[y][x] != '.') {
                        if (arr[y][x] == 'O') {
                            return false;
                        }
                        x--;
                        break;
                    }
                }
                break;
            case 2:
                while (true) {
                    y++;
                    if (arr[y][x] != '.') {
                        if (arr[y][x] == 'O') {
                            return false;
                        }
                        y--;
                        break;
                    }
                }
                break;
            case 3:
                while (true) {
                    x--;
                    if (arr[y][x] != '.') {
                        if (arr[y][x] == 'O') {
                            return false;
                        }
                        x++;
                        break;
                    }
                }
                break;
        }
        arr[y][x] = tmp;
        return true;
    }

    static void print(char[][] arr) {
        for (char[] x : arr) {
            System.out.println(Arrays.toString(x));
        }
        System.out.println();
    }

}

