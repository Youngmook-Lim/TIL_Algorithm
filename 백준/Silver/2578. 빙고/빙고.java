import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 25; i++) {
            if (i != 0 && i % 5 == 0) {
                st = new StringTokenizer(br.readLine());
            }
            int n = Integer.parseInt(st.nextToken());
            mark(n);
            int cnt = check();
            if (cnt >= 3) {
                System.out.println(i + 1);
                break;
            }
        }


        br.close();
    }

    static int check() {

        int cnt = 0;

        // check horizontal, vertical
        for (int i = 0; i < 5; i++) {
            int cntHorizontal = 0;
            int cntVertical = 0;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 0) {
                    cntVertical++;
                }
                if (board[j][i] == 0) {
                    cntHorizontal++;
                }
            }
            if (cntHorizontal == 5) {
                cnt++;
            }
            if (cntVertical == 5) {
                cnt++;
            }
        }

        // check diagonal
        int cntDiagonalLeft = 0;
        int cntDiagonalRight = 0;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] == 0) {
                cntDiagonalLeft++;
            }
            if (board[i][4 - i] == 0) {
                cntDiagonalRight++;
            }
        }
        if (cntDiagonalLeft == 5) {
            cnt++;
        }
        if (cntDiagonalRight == 5) {
            cnt++;
        }

        return cnt;
    }

    static void mark(int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == n) {
                    board[i][j] = 0;
                    return;
                }
            }
        }
    }

}