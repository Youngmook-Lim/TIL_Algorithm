import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static int[] arr;
    static String ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[1000001];
        int cnt = 0;
        n = Integer.parseInt(br.readLine());

        arr[1] = -1;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);

        loop:
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                if (cur == n) {
                    ans = getPath();
                    break loop;
                }

                if (cur * 3 <= n && arr[cur * 3] == 0) {
                    arr[cur * 3] = cur;
                    q.add(cur * 3);
                }
                if (cur * 2 <= n && arr[cur * 2] == 0) {
                    arr[cur * 2] = cur;
                    q.add(cur * 2);
                }
                if (cur + 1 <= n && arr[cur + 1] == 0) {
                    arr[cur + 1] = cur;
                    q.add(cur + 1);
                }
            }
        }

        System.out.println(cnt - 1);
        System.out.println(ans);


        br.close();
    }

    static String getPath() {
        StringBuilder sb = new StringBuilder();
        while (n != -1) {
            sb.append(n).append(' ');
            n = arr[n];
        }
        return sb.toString();
    }


}

