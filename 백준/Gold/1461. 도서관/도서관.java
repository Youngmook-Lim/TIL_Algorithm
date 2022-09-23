import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m, len, ans;
    static Integer[] arr, arrAbs, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new Integer[n];
        arrAbs = new Integer[n];
        visited = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arrAbs[i] = arr[i];
        }

        Arrays.sort(arr);
        int max = 0;
        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            if (Math.abs(arr[i]) > Math.abs(max)) {
                max = arr[i];
                maxIdx = i;
            }
        }

//        System.out.println(maxIdx);

        int initialMax = max;

        int cnt = n;
        int cycle;
        int prev;
        int curIdx = maxIdx;

//        System.out.println(Arrays.toString(arr));

        loop:
        while (cnt > 0) {
            cycle = Math.min(m, cnt);
            prev = 0;
            while (cycle > 0) {
//                System.out.println(arr[curIdx] + "faf");
                if ((prev > 0 && arr[curIdx] < 0) || (prev < 0 && arr[curIdx] > 0)) {
                    ans += Math.abs(prev);
                    break;

                }
                ans += Math.abs(arr[curIdx] - prev);
                prev = arr[curIdx];
                if (cycle == 1) {
                    ans += Math.abs(arr[curIdx]);
                }
                arr[curIdx] = 0;
                cnt--;
                if (cnt == 0) {
                    break loop;
                }
                if (curIdx - 1 == -1 || arr[curIdx - 1] == 0) {
                    curIdx++;
                } else if (curIdx + 1 == n || arr[curIdx + 1] == 0) {
                    curIdx--;
                }
                cycle--;
            }
//            System.out.println(ans);
            max = 0;
            for (int i = 0; i < n; i++) {
                if (Math.abs(arr[i]) > Math.abs(max)) {
                    max = arr[i];
                    curIdx = i;
                }
            }
        }


        System.out.println(ans - Math.abs(initialMax));


        br.close();
    }


}
