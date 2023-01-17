import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int cntB = 0;
        int cntR = 0;
        char cur = input.charAt(0);
        if (cur == 'B') {
            cntB++;
        } else {
            cntR++;
        }

        for (int i = 0; i < n; i++) {
            if (cur != input.charAt(i)) {
                if (cur == 'B') {
                    cntR++;
                } else {
                    cntB++;
                }
                cur = input.charAt(i);
            }
        }

        System.out.println(Math.min(1 + cntB, 1 + cntR));

        br.close();
    }


}



