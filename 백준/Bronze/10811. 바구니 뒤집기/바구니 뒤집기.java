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

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            reverse(start, end, arr);
        }

        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append(x).append(' ');
        }

        System.out.println(sb);

        br.close();
    }

    static void reverse(int s, int e, int[] arr) {
        for (int i = 0; i <= (e - s) / 2; i++) {
            int tmp = arr[s + i];
            arr[s + i] = arr[e - i];
            arr[e - i] = tmp;
        }
    }

}


