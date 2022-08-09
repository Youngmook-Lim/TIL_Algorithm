import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int[] arr;
    static int max;
    static int maxIdx;
    static int min;
    static int minIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());

            arr = new int[100];


            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            while (n >= 0) {
                getMinMax();

                arr[maxIdx]--;
                arr[minIdx]++;

                n--;
            }

            System.out.println("#" + (t + 1) + " " + (max - min));


        }

        br.close();
    }

    static void getMinMax() {
        max = 0;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < 100; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }
    }
}

