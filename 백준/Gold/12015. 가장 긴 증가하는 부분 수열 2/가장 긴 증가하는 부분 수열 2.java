import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static int[] arr;
    static TreeSet<Integer> ts;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ts.add(arr[i]);
            } else {
                if (arr[i] > ts.last()) {
                    ts.add(arr[i]);
                } else {
                    ts.remove(ts.ceiling(arr[i]));
                    ts.add(arr[i]);
                }
            }
        }

        System.out.println(ts.size());

        br.close();
    }


}
