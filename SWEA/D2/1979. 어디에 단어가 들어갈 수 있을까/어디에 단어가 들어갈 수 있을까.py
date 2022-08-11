import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - k + 1; j++) {
                    // k 갯수만큼 연속된 1들이 존재하는지 확인
                    if (check(i, j, false)) {
                        // k 갯수의 1들 양옆에 1이 있으면 cnt--
                        if ((j - 1 >= 0 && arr[i][j - 1] == 1) || (j + k < n && arr[i][j + k] == 1)) {
                            cnt--;
                        }
                        cnt++;
                    }
                    // k 갯수만큼 연속된 1들이 존재하는지 확인
                    if (check(i, j, true)) {
                        // k 갯수의 1들 양옆에 1이 있으면 cnt--
                        if ((j - 1 >= 0 && arr[j - 1][i] == 1) || (j + k < n && arr[j + k][i] == 1)) {
                            cnt--;
                        }
                        cnt++;
                    }
                }
            }

            System.out.println("#" + t + " " + cnt);

        }
        br.close();
    }

    // k 갯수만큼 연속된 1들이 존재하는지 확인하는 함수 (가로, 새로 구분을 위한 reverse 파라미터)
    static boolean check(int i, int j, boolean reverse) {
        boolean flag = true;
        for (int x = j; x < j + k; x++) {
            if (((!reverse) ? arr[i][x] : arr[x][i]) == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}