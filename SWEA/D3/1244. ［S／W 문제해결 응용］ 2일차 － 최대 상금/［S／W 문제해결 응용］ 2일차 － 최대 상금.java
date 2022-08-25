import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int k, len, ans;
    static int[] arr;
    static List<Integer> tmpList;

    static List<int[]> combinations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            char[] tmpArr = st.nextToken().toCharArray();
            len = tmpArr.length;
            arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = tmpArr[i] - '0';
            }
            tmpList = new ArrayList<>();
            combinations = new ArrayList<>();
            ans = 0;


            k = Integer.parseInt(st.nextToken());

            if (k > len) {
                k = len;
            }

            dfs(0);
            findNum(0);

            bw.write("#" + t + " " + ans + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void findNum(int depth) {
        if (depth == k) {
            int total = 0;
            int m = 1;
            for (int i = len - 1; i >= 0; i--) {
                total += arr[i] * m;
                m *= 10;
            }
            ans = Math.max(ans, total);
            return;
        }

        for (int i = 0; i < combinations.size(); i++) {
            swap(combinations.get(i)[0], combinations.get(i)[1]);
            findNum(depth + 1);
            swap(combinations.get(i)[0], combinations.get(i)[1]);
        }
    }

    static void dfs(int start) {
        if (tmpList.size() == 2) {
            combinations.add(new int[]{tmpList.get(0), tmpList.get(1)});
            return;
        }

        for (int i = start; i < len; i++) {
            tmpList.add(i);
            dfs(i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
