import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        for (int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int gap = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for (int i = 0; i < n - 1; i++) {
                int diff = arr[i + 1] - arr[i];
                gap = Math.max(gap, diff);
            }

            String ans = "Max " + arr[n - 1] + ", Min " + arr[0] + ", Largest gap " + gap;
            sb.append("Class ").append(k).append('\n');
            sb.append(ans).append('\n');

        }

        System.out.println(sb);


        br.close();
    }


}
