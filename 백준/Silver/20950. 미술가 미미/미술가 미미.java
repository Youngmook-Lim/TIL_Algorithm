import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static int[][] colors;
    static int[] gom;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        colors = new int[n][3];
        gom = new int[3];
        list = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            colors[i][0] = r;
            colors[i][1] = g;
            colors[i][2] = b;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            gom[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int idx) {
        for (int i = idx; i < n; i++) {
            if (list.size() < n && list.size() < 7) {
                list.add(i);
                if (list.size() > 1) {
                    calc(list.size());
                }
                dfs(i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    static void calc(int s) {
        int[] rgb = {0, 0, 0};

        for (int i = 0; i < s; i++) {
            rgb[0] += colors[list.get(i)][0];
            rgb[1] += colors[list.get(i)][1];
            rgb[2] += colors[list.get(i)][2];
        }

        for (int i = 0; i < 3; i++) {
            rgb[i] /= s;
        }

        int total = 0;
        for (int i = 0; i < 3; i++) {
            total += Math.abs(gom[i] - rgb[i]);
        }

        ans = Math.min(ans, total);
    }

}