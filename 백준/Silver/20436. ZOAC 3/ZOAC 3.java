import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static char[][] keyboard = {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'}, {'a',
            's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', '0'}, {'z', 'x', 'c', 'v', 'b', 'n', 'm', '0', '0'}};
    static int xl, yl, xr, yr;
    static int cnt;
    static String str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        char sl = st.nextToken().charAt(0);
        char sr = st.nextToken().charAt(0);

        int[] resl = getIdx(sl);
        xl = resl[0];
        yl = resl[1];
        int[] resr = getIdx(sr);
        xr = resr[0];
        yr = resr[1];

        str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            int[] rescur = getIdx(cur);
            int x = rescur[0];
            int y = rescur[1];
            char hand;

            if (y < 2) {
                if (x < 5) {
                    hand = 'l';
                } else {
                    hand = 'r';
                }
            } else {
                if (x < 4) {
                    hand = 'l';
                } else {
                    hand = 'r';
                }
            }
            
            if (hand == 'l') {
                cnt += getDist(rescur[0], rescur[1], xl, yl) + 1;
                xl = x;
                yl = y;
            } else {
                cnt += getDist(rescur[0], rescur[1], xr, yr) + 1;
                xr = x;
                yr = y;
            }
        }

        System.out.println(cnt);

        br.close();
    }

    static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static int[] getIdx(char target) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if (keyboard[i][j] == target) {
                    int[] result = new int[2];
                    result[0] = j;
                    result[1] = i;
                    return result;
                }
            }
        }
        return null;
    }


}
