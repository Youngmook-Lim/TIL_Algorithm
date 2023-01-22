import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[1001];

        int n = 1;
        int cnt = 0;

        for (int i = 1; i < 1001; i++) {
            arr[i] = arr[i - 1] + n;
            cnt++;
            if (cnt == n) {
                n++;
                cnt = 0;
            }
        }
        
        System.out.println(arr[b] - arr[a - 1]);

        br.close();
    }


}
