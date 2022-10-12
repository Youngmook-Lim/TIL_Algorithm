import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int n, m, x, y, k, u, d, l, r, curFloor;
    static int[][] graph;
    static Map<Integer, Integer> map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        map = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        curFloor = 6;
        u = 2;
        d = 5;
        l = 4;
        r = 3;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            roll(cmd);
        }

//        sb.setLength(sb.length() - 1);
        System.out.println(sb);

        br.close();
    }

    static void roll(int cmd) {
        int tmp;
        switch (cmd) {
            case 1:
                if (x == m - 1) return;
                l = curFloor;
                tmp = r;
                r = 7 - curFloor;
                curFloor = tmp;
                x++;
                break;
            case 2:
                if (x == 0) return;
                r = curFloor;
                tmp = l;
                l = 7 - curFloor;
                curFloor = tmp;
                x--;
                break;
            case 3:
                if (y == 0) return;
                d = curFloor;
                tmp = u;
                u = 7 - curFloor;
                curFloor = tmp;
                y--;
                break;
            case 4:
                if (y == n - 1) return;
                u = curFloor;
                tmp = d;
                d = 7 - curFloor;
                curFloor = tmp;
                y++;
                break;
        }
        if (graph[y][x] == 0) {
            graph[y][x] = map.get(curFloor);
        } else {
            map.put(curFloor, graph[y][x]);
            graph[y][x] = 0;
        }
        sb.append(map.get(7 - curFloor)).append('\n');
    }


}

