import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static String[] moves;
    static int curX, curY;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static boolean[][] visited;

    static class P {
        int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        moves = new String[36];
        for (int i = 0; i < 36; i++) {
            moves[i] = br.readLine();
        }
        visited = new boolean[6][6];

        for (int i = 0; i < 36; i++) {
            P p = getCoords(moves[i]);
            if (visited[p.y][p.x]) {
                System.out.println("Invalid");
                return;
            }

            if (i != 0) {
                if (!isPossible(curX, curY, p)) {
                    System.out.println("Invalid");
                    return;
                }
            }
            curX = p.x;
            curY = p.y;
            visited[curY][curX] = true;
        }


        if (!isPossible(curX, curY, getCoords(moves[0]))) {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");


        br.close();
    }

    static P getCoords(String s) {
        int x = s.charAt(0) - 'A';
        int y = Integer.parseInt(Character.toString(s.charAt(1))) - 1;
        return new P(x, y);
    }

    static boolean isPossible(int x, int y, P p) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx == p.x && ny == p.y) return true;
        }
        return false;
    }


}


