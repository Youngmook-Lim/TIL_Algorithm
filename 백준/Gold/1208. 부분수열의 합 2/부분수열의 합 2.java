import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, s;
    static long ans;
    static int[] arr;
    static Map<Integer, Integer> hashMap;

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

        hashMap = new HashMap<>();

        createPowerSet(0, n / 2, 0, 1);
        createPowerSet(n / 2 + 1, n - 1, 0, 2);

        if (s == 0) {
            ans--;
        }

        System.out.println(ans);

        br.close();
    }

    static void createPowerSet(int start, int end, int sum, int type) {
        if (start > end) {
            if (type == 1) {
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            } else {
                ans += hashMap.getOrDefault(s - sum, 0);
            }
            return;
        }
        createPowerSet(start + 1, end, sum, type);
        createPowerSet(start + 1, end, sum + arr[start], type);

    }


}
