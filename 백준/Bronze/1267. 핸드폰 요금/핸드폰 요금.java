import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static int[] arr;
    static final int INTERVAL_Y = 30;
    static final int INTERVAL_M = 60;
    static final int RATE_Y = 10;
    static final int RATE_M = 15;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int Y = getRate('Y');
        int M = getRate('M');

        if (Y == M) {
            System.out.println("Y M " + Y);
        } else if (Y < M) {
            System.out.println("Y " + Y);
        } else {
            System.out.println("M " + M);
        }

        br.close();
    }

    static int getRate(char opt) {
        return opt == 'M' ? calculateM() : calculateY();
    }

    static int calculateY() {
        int total = 0;
        for (int x : arr) {
            total += ((x / INTERVAL_Y) + 1) * RATE_Y;
        }
        return total;
    }

    static int calculateM() {
        int total = 0;
        for (int x : arr) {
            total += ((x / INTERVAL_M) + 1) * RATE_M;
        }
        return total;
    }

}
