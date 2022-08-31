import java.io.*;

public class Main {

    static int n;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new boolean[2000001];
        arr[1] = true;

        for (int i = 2; i < Math.sqrt(2000001) + 1; i++) {
            if (!arr[i]) {
                for (int j = i * 2; j < 2000001; j += i) {
                    arr[j] = true;
                }
            }
        }

        while (true) {
            StringBuilder sb = new StringBuilder();
            String nStr = Integer.toString(n);
            sb.append(n);
            if (!arr[n] && nStr.equals(sb.reverse().toString())) {
                bw.write(n + "\n");
                break;
            }
            n++;
        }

        bw.flush();
        bw.close();
        br.close();
    }


}