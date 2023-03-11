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
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        for (int l = 0; l < m; l++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken()) - 1;

            int[] tmp = new int[j - i + 1];
            for (int a = i; a <= j; a++) {
                tmp[a - i] = arr[a];
            }

            for (int a = 0; a < j - i + 1; a++) {
                arr[a + i] = tmp[(a + k - i) % (j - i + 1)];
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


