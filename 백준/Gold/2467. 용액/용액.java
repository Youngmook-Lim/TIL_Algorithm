import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static List<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = new ArrayList<>();
        int start = 0;
        int end = n - 1;
        int min = Integer.MAX_VALUE;

        while (start < end) {
            int total = arr[start] + arr[end];

            if (Math.abs(total) < min) {
                min = Math.abs(total);
                ans.clear();
                ans.add(arr[start]);
                ans.add(arr[end]);
            }

            if (total == 0) {
                ans.clear();
                ans.add(arr[start]);
                ans.add(arr[end]);
                break;
            } else if (total > 0) {
                end--;
            } else {
                start++;
            }

        }

        for (int x : ans) {
            System.out.print(x + " ");
        }


        br.close();

    }

}