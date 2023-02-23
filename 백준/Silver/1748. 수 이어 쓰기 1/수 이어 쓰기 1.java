import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long cnt = 0;
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 9; i++) {
            cnt += i * (Math.min(n, Math.pow(10, i) - 1) - Math.pow(10, i - 1) + 1);

            if (n < Math.pow(10, i)) {
                break;
            }
        }
        
        System.out.println(cnt);

        br.close();
    }


}


