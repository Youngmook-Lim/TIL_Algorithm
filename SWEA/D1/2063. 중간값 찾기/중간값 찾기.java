import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int mid = n / 2 + 1;
        int[] arr = new int[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        for (int i = 1; i <= 100; i++) {
            arr[i] += arr[i - 1];
        }

        for (int i = 0; i <= 100; i++) {
            if (arr[i] == mid) {
                System.out.println(i);
                break;
            }
        }
        
        br.close();
    }

}