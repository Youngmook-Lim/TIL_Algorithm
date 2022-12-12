import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static int[] arr;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i == 0 || list.get(list.size() - 1) < arr[i]) {
                list.add(arr[i]);
            } else {
                int idx = findIdx(0, list.size() - 1, arr[i]);
                list.set(idx, arr[i]);
            }
        }

        System.out.println(list.size());

        br.close();
    }

    static int findIdx(int start, int end, int target) {
        if (start > end) {
            return start;
        }

        int mid = (start + end) / 2;
        if (list.get(mid) >= target) {
            return findIdx(start, mid - 1, target);
        } else {
            return findIdx(mid + 1, end, target);
        }
    }

}
