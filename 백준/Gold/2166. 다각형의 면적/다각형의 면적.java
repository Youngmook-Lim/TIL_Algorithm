import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 신발끈 공식 활용
 * */
public class Main {

    static int n;
    static P[] arr;

    static class P {
        int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new P[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new P(x, y);
        }

        long a = 0;
        long b = 0;

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                a += (long) arr[i].x * arr[0].y;
                b += (long) arr[i].y * arr[0].x;
            } else {
                a += (long) arr[i].x * arr[i + 1].y;
                b += (long) arr[i].y * arr[i + 1].x;
            }
        }

        System.out.printf("%.1f%n", (double) Math.abs(a - b) / 2);

        br.close();
    }


}

