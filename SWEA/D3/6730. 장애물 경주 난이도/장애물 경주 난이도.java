

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int maxUp = 0;
            int maxDown = 0;

            for (int i = 1; i < n; i++) {
                int dif = arr[i] - arr[i - 1];
                if (arr[i] > arr[i - 1]) {
                    if (dif > maxUp) {
                        maxUp = dif;
                    }
                } else if (arr[i] < arr[i - 1]) {
                    if (-dif > maxDown) {
                        maxDown = -dif;
                    }
                }
            }

            System.out.println("#" + t + " " + maxUp + " " + maxDown);

        }
    }
}
