import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int n, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        while (n > 0) {
            if (n % 5 == 0) {
                ans += n / 5;
                n = 0;
                break;
            }
            n -= 2;
            ans++;
        }

        if (n == 0) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }

        br.close();
    }


}