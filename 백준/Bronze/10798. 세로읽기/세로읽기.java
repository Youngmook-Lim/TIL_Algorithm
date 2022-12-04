import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static String[] arr;
    static int[] arrLen;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        arr = new String[5];
        arrLen = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
            arrLen[i] = arr[i].length();
        }

        for (int i = 0; i < 15; i++) {
            boolean flag = false;
            for (int j = 0; j < 5; j++) {
                if (arrLen[j] <= i) continue;
                flag = true;
                sb.append(arr[j].charAt(i));
            }
            if (!flag) {
                break;
            }
        }

        System.out.println(sb);

        br.close();
    }


}
