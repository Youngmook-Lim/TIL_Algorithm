import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int gcd = arr[0];
        for (int i = 1; i < n; i++) {
            gcd = getGCD(gcd, arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= Math.sqrt(gcd); i++) {
            if (gcd % i == 0) {
                list.add(i);
                if (gcd / i != i) {
                    list.add(gcd / i);
                }
            }
        }

        Collections.sort(list);

        for (int x : list) {
            sb.append(x).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    static int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }


}

