import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static String s, p;
    static int ans;
    static int[] pi;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        p = br.readLine();
        pi = new int[s.length()];

        getPi();
        KMP();

        System.out.println(ans);

        br.close();

    }

    static void getPi() {
        int j = 0;
        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }

    static void KMP() {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                j++;
                if (j == p.length()) {
                    ans = 1;
                    return;
                }
            }
        }
    }


}