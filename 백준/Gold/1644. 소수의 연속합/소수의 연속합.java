import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static final int MAX = 4000001;
    static int n, idx, start, end, ans, endPoint;
    static boolean[] primes;
    static int[] primesPrefix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        idx = 1;
        primes = new boolean[MAX + 1];
        primesPrefix = new int[MAX + 1];
        for (int i = 2; i < Math.sqrt(MAX) + 1; i++) {
            if (primes[i]) continue;
            for (int j = i * 2; j < MAX + 1; j += i) {
                primes[j] = true;
            }
        }

        for (int i = 2; i < MAX + 1; i++) {
            if (i == n) {
                endPoint = idx;
            }
            if (primes[i]) continue;
            primesPrefix[idx] = primesPrefix[idx++ - 1] + i;
        }

        start = 0;
        end = 1;

        while (end <= endPoint) {
            int sum = primesPrefix[end] - primesPrefix[start];
            if (sum == n) {                
                ans++;
                start++;
            } else if (sum > n) {
                start++;
            } else {
                end++;
            }
        }

        System.out.println(ans);

        br.close();

    }


}