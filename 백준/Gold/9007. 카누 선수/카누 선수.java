import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 987654321;
    static int k, n, idx, ans, minDiff;
    static int[][] classes;
    static int[] superclassA;
    static int[] superclassB;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            minDiff = INF;
            ans = 0;
            idx = 0;
            flag = false;
            classes = new int[4][n];
            superclassA = new int[n * n];
            superclassB = new int[n * n];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    classes[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    superclassA[idx++] = classes[0][i] + classes[1][j];
                }
            }
            idx = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    superclassB[idx++] = classes[2][i] + classes[3][j];
                }
            }
            Arrays.sort(superclassB);

            for (int i = 0; i < n * n; i++) {
                int curA = superclassA[i];
                binSearch(curA, 0, n * n - 1);
                if (minDiff == 0) {
                    break;
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);

        br.close();
    }

    static void binSearch(int curA, int start, int end) {
        if (flag) return;
        if (start > end) return;

        int mid = (start + end) / 2;
        int total = curA + superclassB[mid];
        int diff = total - k;

        if (Math.abs(diff) <= minDiff) {
            if (Math.abs(diff) == minDiff) {
                if (total < ans) {
                    ans = total;
                }
            } else {
                minDiff = Math.abs(diff);
                ans = total;
            }
        }

        if (diff == 0) {
            flag = true;
        } else if (diff > 0) {
            binSearch(curA, start, mid - 1);
        } else {
            binSearch(curA, mid + 1, end);
        }

    }

}
