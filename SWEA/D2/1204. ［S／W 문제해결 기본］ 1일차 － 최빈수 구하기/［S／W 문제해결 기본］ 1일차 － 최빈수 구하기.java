
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int a = Integer.parseInt(br.readLine());
            int[] arr = new int[1000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {

                int stu = Integer.parseInt(st.nextToken());
                arr[stu] += 1;
            }

            int max = Arrays.stream(arr).max().getAsInt();

            for (int i = 999; i >= 0; i--) {
                if (arr[i] == max) {
                    System.out.println("#" + t + " " + i);
                    break;
                }
            }

        }
        br.close();
    }
}
