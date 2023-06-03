import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int n, l;
    static int[] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int idx = 0;
        int cnt = 0;

        while (idx < n) {
            int cur = arr[idx];
            int until = cur + l;
            while (idx < n && arr[idx] < until) {
                idx++;
            }
            cnt++;
        }

        System.out.println(cnt);

        br.close();
    }


}
