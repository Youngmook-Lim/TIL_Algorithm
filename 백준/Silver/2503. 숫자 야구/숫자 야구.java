import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        check = new int[1000];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int j = 111; j < 1000; j++) {
                String curNum = Integer.toString(j);
                if (curNum.contains("0") || curNum.charAt(0) == curNum.charAt(1)
                        || curNum.charAt(1) == curNum.charAt(2) || curNum.charAt(2) == curNum.charAt(0)) continue;

                int cntStrike = 0;
                int cntBall = 0;
                boolean[] isStrike = new boolean[3];
                for (int k = 0; k < 3; k++) {
                    if (num.charAt(k) == curNum.charAt(k)) {
                        cntStrike++;
                        isStrike[k] = true;
                    }
                }

                boolean[] isBall = new boolean[3];

                for (int k = 0; k < 3; k++) {
                    if (isStrike[k]) continue;
                    for (int l = 0; l < 3; l++) {
                        if (k == l || isBall[l]) continue;
                        if (num.charAt(k) == curNum.charAt(l)) {
                            cntBall++;
                            isBall[l] = true;
                            break;
                        }
                    }
                }
                if (cntStrike == strike && cntBall == ball) {
                    check[j]++;
                }
            }
        }

        for (int i = 111; i < 1000; i++) {
            String curNum = Integer.toString(i);
            if (curNum.contains("0") || curNum.charAt(0) == curNum.charAt(1)
                    || curNum.charAt(1) == curNum.charAt(2) || curNum.charAt(2) == curNum.charAt(0)) continue;
            if (check[i] == n) {
                ans++;
            }
        }

        bw.write(ans + "\n");


        bw.flush();
        bw.close();
        br.close();
    }


}