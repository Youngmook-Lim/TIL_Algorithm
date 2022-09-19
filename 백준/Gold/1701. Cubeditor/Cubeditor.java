import java.io.*;
import java.util.Arrays;

public class Main {

    static String str;
    static int ans, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        n = str.length();

        for (int i = 0; i < n-1; i++) {
            KMP(str.substring(i, n));
        }

        bw.write(ans + "\n");


        bw.flush();
        bw.close();
        br.close();
    }

    static void KMP(String subStr) {
        int len = subStr.length();
        int[] pi = new int[len];
        int leftIdx = 0;
        int max = 0;
        for (int rightIdx = 1; rightIdx < len; rightIdx++) {
            while (leftIdx > 0 && subStr.charAt(rightIdx) != subStr.charAt(leftIdx)) {
                leftIdx = pi[leftIdx - 1];
            }
            if (subStr.charAt(leftIdx) == subStr.charAt(rightIdx)) {
                pi[rightIdx] = ++leftIdx;
                max = Math.max(max, leftIdx);
            }
        }
        ans = Math.max(ans, max);
    }

}