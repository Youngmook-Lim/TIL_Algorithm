import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int a, b;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sbAns = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        arr = new boolean[b + 1];

        for (int i = 2; i < Math.sqrt(b) + 1; i++) {
            if (!arr[i]) {
                for (int j = i * i; j < b + 1; j += i) {
                    arr[j] = true;
                }
            }
        }

        while (a <= b) {
            if (!arr[a]) {
                if (checkPalin(a)) {
                    sbAns.append(a).append("\n");
                }
            }
            a++;
        }
        sbAns.append(-1 + "\n");
        bw.write(sbAns.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean checkPalin(int a) {
        int n = a;
        int k = 0;

        while (n > 0) {
            k *= 10;
            k += n % 10;
            n /= 10;
        }
        return k == a;
    }

}