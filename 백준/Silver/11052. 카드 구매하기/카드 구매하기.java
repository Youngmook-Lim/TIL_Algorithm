import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i / 2 + 1; j++) {
                arr[i] = Math.max(arr[i], arr[j] + arr[i - j]);
            }
        }

        System.out.println(arr[n]);

        br.close();
    }


}


