

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
//        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            char[][] table = new char[8][8];
            int cnt = 0;

            for (int i = 0; i < 8; i++) {
                String[] tmp = br.readLine().split("");
                for (int j = 0; j < 8; j++) {
                    table[i][j] = tmp[j].charAt(0);
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8 - n + 1; j++) {
                    char[] subArray = Arrays.copyOfRange(table[i], j, j + n);
                    if (checkP(subArray)) {
                        cnt++;
                    }

                    char[] subArray2 = new char[n];
                    for (int k = 0; k < n; k++) {
                        subArray2[k] = table[k + j][i];
                    }
                    if (checkP(subArray2)) {
                        cnt++;
                    }
                }

            }

            System.out.println("#" + t + " " + cnt);


        }


        br.close();
    }

    static boolean checkP(char[] arr) {
        String original = new String(arr);
        String reverse = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            reverse += arr[i];
        }
        return original.equals(reverse);
    }
}