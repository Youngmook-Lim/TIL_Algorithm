import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] maxArr = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            if (i == 0) {
                int total = 0;
                for (int j = i; j < i + k; j++) {
                    total += arr[j];
                }
                maxArr[i] = total;
            } else {
                maxArr[i] = maxArr[i - 1] - arr[i - 1] + arr[i + k - 1];
            }
        }

        System.out.println(Arrays.stream(maxArr).max().getAsInt());

        br.close();
    }
}


