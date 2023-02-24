import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int a = 0; a < m; a++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken());

            while (i <= j) {
                arr[i] = k;
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append(x).append(' ');
        }

        System.out.println(sb);

        br.close();
    }


}


