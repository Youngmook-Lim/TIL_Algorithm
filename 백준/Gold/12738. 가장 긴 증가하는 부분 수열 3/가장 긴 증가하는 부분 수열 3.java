import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, idx;
    static int[] arr, LIS;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        LIS = new int[n];
        idx = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i] > LIS[idx - 1]) {
                LIS[idx++] = arr[i];
            } else {
                int pos = findIndex(0, idx - 1, arr[i]);
                LIS[pos] = arr[i];
            }
        }

        System.out.println(idx);


        br.close();
    }

    static int findIndex(int start, int end, int target) {
        if (start > end) {
            return start;
        }

        int mid = (start + end) / 2;

        if (LIS[mid] < target) {
            return findIndex(mid + 1, end, target);
        } else {
            return findIndex(start, mid - 1, target);
        }

    }


}

