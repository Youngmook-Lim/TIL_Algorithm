import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int n, target, ans, idx;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            ans = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            target = arr[n - 1];
            idx = n - 2;
            while (true) {
                int curTree = arr[idx];
                int water = ans % 2 == 0 ? 1 : 2;
//                System.out.println(target);
//                System.out.println("--");
//                System.out.println(curTree);
//                System.out.println(idx);
//                System.out.println(ans);

                if (target == curTree) {
                    ans--;
                } else if (target - curTree == 2) {
                    if (water == 2) {
                        arr[idx] += water;
                    } else {
                        int tmpIdx = idx;
                        while (tmpIdx > -1 && target - arr[tmpIdx] <= 2) {
                            tmpIdx--;
                        }
                        if (tmpIdx != -1) {
                            arr[tmpIdx] += water;
                        }
                    }
                } else if (target - curTree == 1) {
                    if (water == 1) {
                        arr[idx] += water;
                    } else {
                        int tmpIdx = idx;
                        while (tmpIdx > -1 && target - arr[tmpIdx] < 2) {
                            tmpIdx--;
                        }
                        if (tmpIdx != -1) {
                            arr[tmpIdx] += water;
                        }
                    }
                } else {
                    arr[idx] += water;
                }

                if (arr[idx] == target) {
                    idx--;
                }
                ans++;

                if (idx == -1) break;
            }

            sb.append("#" + t + " " + ans + '\n');

        }

        System.out.println(sb);

        br.close();
    }


}

