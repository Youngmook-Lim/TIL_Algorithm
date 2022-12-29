import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, x;
    static int[] arr;

    static int cnt;
    static double total;
    static double mean;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int result = getGcd(x, arr[i]);
            if (result == 1) {
                cnt++;
                total += arr[i];
            }
        }

        mean = total / cnt;

        System.out.println(mean);

        br.close();
    }

    static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }


}

