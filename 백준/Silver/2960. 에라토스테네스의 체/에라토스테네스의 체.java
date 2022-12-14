import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int n, k, ans;
    static boolean[] eratosthenes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        eratosthenes = new boolean[n + 1];

        loop:
        for (int i = 2; i < n + 1; i++) {
            if (!eratosthenes[i]) {
                for (int j = i; j < n + 1; j = j + i) {
                    if (eratosthenes[j]) continue;
                    eratosthenes[j] = true;
                    k--;
                    if (k == 0) {
                        ans = j;
                        break loop;
                    }
                }
            }
        }

        System.out.println(ans);

        br.close();
    }
}
