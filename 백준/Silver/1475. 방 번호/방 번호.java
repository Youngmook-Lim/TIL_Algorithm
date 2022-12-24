import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String n = br.readLine();
        int[] arr = new int[10];
        int ans = 0;

        for (int i = 0; i < n.length(); i++) {
            arr[n.charAt(i) - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) continue;
            ans = Math.max(ans, arr[i]);
        }

        ans = Math.max(ans, (arr[6] + arr[9] + 1) / 2);

        System.out.println(ans);

        br.close();
    }

}
