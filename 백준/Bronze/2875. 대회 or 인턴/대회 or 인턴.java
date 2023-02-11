import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;

        while (n >= 2 && m >= 1) {
            n -= 2;
            m -= 1;
            cnt++;
        }

        int leftovers = n + m;
        int needed = k - leftovers;

        if (needed > 0) {
            cnt -= (needed + 2) / 3;
        }
        
        System.out.println(cnt);

        br.close();
    }


}














