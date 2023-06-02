import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static int[] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int prev = arr[n - 1];
        int idx = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > prev) {
                idx = i;
                prev = arr[i];
            } else {
                break;
            }
        }

        if (idx == 0) {
            System.out.println(-1);
            return;
        }

        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = idx; i < n; i++) {
            if (arr[i] > arr[idx - 1]) {
                if (arr[i] < min) {
                    min = arr[i];
                    minIdx = i;
                }

            }
        }

        swap(minIdx, idx - 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < idx; i++) {
            sb.append(arr[i]).append(' ');
        }
        for (int i = n - 1; i >= idx; i--) {
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);

        br.close();
    }

    static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


}
