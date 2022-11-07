import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n;
    static int[] arr;
    static Deque<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[1000001];
        int cnt = 0;
        n = Integer.parseInt(br.readLine());

        arr[n] = -1;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);

        loop:
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                if (cur == 1) {
                    ans = getPath();
                    break loop;
                }

                if (cur % 3 == 0 && cur / 3 >= 1 && arr[cur / 3] == 0) {
                    arr[cur / 3] = cur;
                    q.add(cur / 3);
                }
                if (cur % 2 == 0 && cur / 2 >= 1 && arr[cur / 2] == 0) {
                    arr[cur / 2] = cur;
                    q.add(cur / 2);
                }
                if (cur - 1 >= 1 && arr[cur - 1] == 0) {
                    arr[cur - 1] = cur;
                    q.add(cur - 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt - 1).append('\n');
        for (int x : ans) {
            sb.append(x).append(' ');
        }

        System.out.println(sb);
        br.close();
    }

    static Deque<Integer> getPath() {
        Deque<Integer> result = new ArrayDeque<>();
        int start = 1;
        while (start != -1) {
            result.addFirst(start);
            start = arr[start];
        }
        return result;
    }


}

