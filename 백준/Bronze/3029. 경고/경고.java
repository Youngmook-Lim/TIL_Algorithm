import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String[] cur = br.readLine().split(":");
        String[] explode = br.readLine().split(":");

        int[] curInt = new int[3];
        int[] explodeInt = new int[3];
        int[] wait = new int[3];

        for (int i = 0; i < 3; i++) {
            curInt[i] = Integer.parseInt(cur[i]);
            explodeInt[i] = Integer.parseInt(explode[i]);
        }

        for (int i = 2; i >= 0; i--) {

            if (explodeInt[i] >= curInt[i]) {
                wait[i] = explodeInt[i] - curInt[i];
            } else {
                if (i > 0) {
                    explodeInt[i - 1]--;
                    wait[i] = 60 + explodeInt[i] - curInt[i];
                } else {
                    wait[i] = 24 + explodeInt[i] - curInt[i];
                }
            }
        }

        if (wait[0] == 0 && wait[1] == 0 && wait[2] == 0) {
            sb.append("24:00:00").append('\n');
        } else {
            for (int x : wait) {
                sb.append(String.format("%02d", x)).append(':');
            }
        }

        sb.setLength(sb.length() - 1);

        System.out.println(sb);

        br.close();
    }


}

