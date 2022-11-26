import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static String num;
    static int base, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        num = st.nextToken();
        base = Integer.parseInt(st.nextToken());

        int len = num.length();

        for (int i = len - 1; i >= 0; i--) {
            char cur = num.charAt(i);
            int curInt = convert(cur);
            ans += Math.pow(base, (len - i - 1)) * (curInt);
        }

        System.out.println(ans);

        br.close();

    }

    static int convert(char cur) {
        if (cur - '0' >= 0 && cur - '0' < 10) {
            return cur - '0';
        } else {
            return cur - 55;
        }
    }


}