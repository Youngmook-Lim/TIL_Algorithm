import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int k, ans;
    static LinkedList<Integer>[] topni;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        topni = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            topni[i] = new LinkedList<>();
            String tmp = br.readLine();
            for (int j = 0; j < 8; j++) {
                topni[i].add(tmp.charAt(j) - '0');
            }
        }
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            turn(n, dir);
        }

        for (int i = 0; i < 4; i++) {
            ans += Math.pow(2, i) * topni[i].peek();
        }

        System.out.println(ans);

        br.close();
    }

    static void turn(int n, int dir) {
        int[] turnable = new int[4];
        turnable[n] = dir;
        int idx = n - 1;
        while (idx >= 0) {
            if (turnable[idx + 1] == 0) break;
            if (topni[idx].get(2) == topni[idx + 1].get(6)) {
                turnable[idx] = 0;
            } else {
                if (n - idx == 2) {
                    turnable[idx] = dir;
                } else {
                    turnable[idx] = -dir;
                }
            }
            idx--;
        }
        idx = n + 1;
        while (idx < 4) {
            if (turnable[idx - 1] == 0) break;
            if (topni[idx].get(6) == topni[idx - 1].get(2)) {
                turnable[idx] = 0;
            } else {
                if (idx - n == 2) {
                    turnable[idx] = dir;
                } else {
                    turnable[idx] = -dir;
                }
            }
            idx++;
        }

        for (int i = 0; i < 4; i++) {
            if (turnable[i] == 1) {
                int tmp = topni[i].pollLast();
                topni[i].addFirst(tmp);
            } else if (turnable[i] == -1) {
                int tmp = topni[i].pollFirst();
                topni[i].addLast(tmp);
            }
        }

    }


}

