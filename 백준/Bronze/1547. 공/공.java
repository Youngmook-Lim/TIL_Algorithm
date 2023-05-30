import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[4];
        for (int i = 1; i <= 3; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == y) continue;
            swap(x, y, arr);
        }

        boolean flag = false;
        for (int i = 1; i <= 3; i++) {
            if (arr[i] == 1) {
                System.out.println(i);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(-1);
        }

        br.close();
    }

    static void swap(int x, int y, int[] arr) {
        int tmp = arr[y];
        arr[y] = arr[x];
        arr[x] = tmp;
    }


}
