import java.io.*;

public class Main {

    static String str;
    static int ans, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        n = str.length();

        for (int i = 0; i < n - 1; i++) {
            int[] pi = new int[n - i];
            int idx = i;
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                while (idx > i && str.charAt(j) != str.charAt(idx)) {
                    idx = pi[idx - 1 - i] + i;
                }
                if (str.charAt(idx) == str.charAt(j)) {
                    pi[j - i] = ++idx - i;
                    max = Math.max(max, idx - i);
                }
            }
//            System.out.println(Arrays.toString(pi));
            ans = Math.max(ans, max);
        }

        bw.write(ans + "\n");


        bw.flush();
        bw.close();
        br.close();
    }

}