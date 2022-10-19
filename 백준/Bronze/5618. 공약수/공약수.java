import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= min; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (arr[j] % i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);


        br.close();
    }


}

