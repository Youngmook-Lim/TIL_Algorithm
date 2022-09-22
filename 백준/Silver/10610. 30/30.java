import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] - '0';
            if (arr[i] == '0') {
                flag = true;
            }
        }

        if (sum % 3 == 0 && flag) {
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for (int i = arr.length - 1; i >= 0; i--) {
                sb.append(arr[i]);
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }

        br.close();
    }

}