import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static int[] dx = {1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1};
    static int ans, xPos, yPos;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        board = new int[19][19];

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        loop:
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] == 1 || board[i][j] == 2) {
                    check(i, j, board[i][j]);
                    if (flag) {
                        break loop;
                    }
                }
            }
        }

        if (flag) {
            bw.write(ans + "\n");
            bw.write(yPos + " " + xPos + "\n");
        } else {
            bw.write(0 + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static void check(int y, int x, int type) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int len = 1;

            while (true) {
                if (len == 5) {
                    if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && board[ny][nx] == type) {
                        break;
                    }
                    if (x - dx[i] >= 0 && x - dx[i] < 19 && y - dy[i] >= 0 && y - dy[i] < 19
                            && board[y - dy[i]][x - dx[i]] == type) {
                        break;
                    }
                    flag = true;
                    ans = type;
                    xPos = x + 1;
                    yPos = y + 1;
                    return;
                }

                if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && board[ny][nx] == type) {
                    nx += dx[i];
                    ny += dy[i];
                    len++;
                } else {
                    break;
                }
            }
        }
    }
}

