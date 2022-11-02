import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static final int INF = 1000000007;
    static int m;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            ans = (ans + (s % INF * power(n, INF - 2) % INF)) % INF;
        }

        System.out.println(ans);

        br.close();
    }

    static long power(int num, int pow) {
        if (pow == 1) return num;

        long answer = power(num, pow / 2);

        if (pow % 2 == 0) {
            return (answer * answer) % INF;
        } else {
            return (((answer * answer) % INF) * num) % INF;
        }

    }


}

