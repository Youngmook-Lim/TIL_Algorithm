import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] sudoku;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sudoku = new int[9][9];
        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(Character.toString(tmp.charAt(j)));
                if (sudoku[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        dfs(0);

        br.close();
    }

    static void dfs(int idx) {

        if (idx == list.size()) {
            for (int[] arr : sudoku) {
                for (int x : arr) {
                    System.out.print(x);
                }
                System.out.println();
            }
            System.exit(0);
        }


        for (int i = 0; i < 9; i++) {
            if (check(list.get(idx)[0], list.get(idx)[1], i + 1)) {
                sudoku[list.get(idx)[0]][list.get(idx)[1]] = i + 1;
                dfs(idx + 1);
                sudoku[list.get(idx)[0]][list.get(idx)[1]] = 0;
            }
        }
    }


    static boolean check(int y, int x, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[y][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (sudoku[i][x] == value) {
                return false;
            }
        }

        int start_x = 3 * (x / 3);
        int start_y = 3 * (y / 3);

        for (int i = start_y; i < start_y + 3; i++) {
            for (int j = start_x; j < start_x + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}