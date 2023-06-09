import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int start = 0;
        int end = 0;
        int cnt = 0;
        int sum = 0;

        while (start <= n && end <= n) {
            if (sum == n) {
                cnt++;
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }

        System.out.println(cnt);

        br.close();
    }


}
