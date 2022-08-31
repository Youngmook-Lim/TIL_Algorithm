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
                for (int j = i * 2; j < b + 1; j += i) {
                    arr[j] = true;
                }
            }
        }

        while (a <= b) {
            if (!arr[a]) {
                StringBuilder sb = new StringBuilder();
                String nStr = Integer.toString(a);
                sb.append(a);
                if (nStr.equals(sb.reverse().toString())) {
                    sbAns.append(a).append("\n");
                }
            }
            if (a == b) {
                sbAns.append(-1 + "\n");
            }
            a++;
        }

        bw.write(sbAns.toString());

        bw.flush();
        bw.close();
        br.close();
    }


}