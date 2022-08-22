import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static String a;
    static String b;
    static char[] oneHole = {'A', 'D', 'O', 'P', 'Q', 'R'};

    public static boolean glasses() {
        if (a.length() != b.length()) return false;

        boolean flag = true;

        for (int i = 0; i < a.length(); i++) {
            if ((a.charAt(i) == 'B' && b.charAt(i) != 'B') ||
                    (a.charAt(i) != 'B' && b.charAt(i) == 'B')) {
                flag = false;
                break;
            } else if ((new String(oneHole).contains(Character.toString(a.charAt(i))) &&
                    !(new String(oneHole).contains(Character.toString(b.charAt(i))))) ||
                    !(new String(oneHole).contains(Character.toString(a.charAt(i)))) &&
                            (new String(oneHole).contains(Character.toString(b.charAt(i))))
            ) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            a = st.nextToken();
            b = st.nextToken();

            boolean ans = glasses();

            bw.write("#" + t + " " + (ans ? "SAME" : "DIFF") + "\n");
        }


        bw.flush();
        bw.close();
        br.close();

    }

}