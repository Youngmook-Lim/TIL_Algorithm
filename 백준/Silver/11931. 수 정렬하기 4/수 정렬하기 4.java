import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2_000_001];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine()) + 1_000_000]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2_000_000; i >= 0; i--) {
            if (arr[i] != 0) {
                sb.append(i - 1_000_000).append('\n');
            }
        }

        System.out.println(sb);

        br.close();
    }


}
