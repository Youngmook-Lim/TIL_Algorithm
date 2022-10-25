import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int a, t, type, idx, round;
    static int[] zeroOne;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());
        type = Integer.parseInt(br.readLine());
        zeroOne = new int[2];
        round = 2;

        loop:
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    zeroOne[0]++;
                } else {
                    zeroOne[1]++;
                }
                if (check()) break loop;
                idx = (idx + 1) % a;
            }
            for (int i = 0; i < round * 2; i++) {
                if (i < round) {
                    zeroOne[0]++;
                } else {
                    zeroOne[1]++;
                }
                if (check()) break loop;
                idx = (idx + 1) % a;
            }
            round++;
        }

        System.out.println(idx);

        br.close();
    }

    static boolean check() {
        return zeroOne[type] == t;
    }


}

