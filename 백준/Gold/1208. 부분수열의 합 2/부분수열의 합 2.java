import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, s;
    static long ans;
    static int[] arr;
    static List<Integer> listLeft, listRight;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        listLeft = new ArrayList<>();
        listRight = new ArrayList<>();

        createPowerSet(0, n / 2, listLeft);
        createPowerSet(n / 2 + 1, n - 1, listRight);

        Collections.sort(listLeft);
        Collections.sort(listRight);

        calculate();

        if (s == 0) {
            ans--;
        }

        System.out.println(ans);

        br.close();
    }

    static void calculate() {
        int pointerL = 0;
        int pointerR = listRight.size() - 1;

        while (pointerL < listLeft.size() && pointerR >= 0) {
            int lSum = listLeft.get(pointerL);
            int rSum = listRight.get(pointerR);
            long sum = lSum + rSum;
            if (sum == s) {
                long rCnt = 0;
                long lCnt = 0;
                while (pointerL < listLeft.size() && listLeft.get(pointerL) == lSum) {
                    lCnt++;
                    pointerL++;
                }
                while (pointerR >= 0 && listRight.get(pointerR) == rSum) {
                    rCnt++;
                    pointerR--;
                }
                ans += lCnt * rCnt;
            } else if (sum > s) {
                pointerR--;
            } else {
                pointerL++;
            }
        }
    }

    static void createPowerSet(int start, int end, List<Integer> list) {
        int num = end - start + 1;
        for (int i = 0; i < (1 << num); i++) {
            int tmp = 0;
            for (int j = 0; j < num; j++) {
                if ((i & (1 << j)) != 0) {
                    tmp += arr[start + j];
                }
            }
            list.add(tmp);
        }
    }


}
