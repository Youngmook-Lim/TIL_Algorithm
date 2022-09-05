import java.io.*;
import java.util.*;

public class Main {

    static int n, start, num, ans;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, -1, 1};
    static int[] dy = {1, 1, -1, -1};
    static List<int[]> list, container;
    static boolean x, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];
        list = new ArrayList<>();
        container = new ArrayList<>();
        start = 1;
        x = true;
        X = true;
        num = 0;
        ans = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    list.add(new int[]{i, j});
                    num++;
                }
            }
        }

        while (true) {
            X = false;
            dfs(0, 'B');
            if (X) {
                start++;
            } else {
                break;
            }
//            System.out.println(start);
        }
        ans += start - 1;
        start = 1;
//        System.out.println(ans);

        while (true) {
            X = false;
            dfs(0, 'W');
            if (X) {
                start++;
            } else {
                break;
            }
//            System.out.println(start);
        }
        ans += start - 1;

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int idx, char type) {
        if (X) return;

        if (container.size() == start) {
//            for (int[] a : container) {
//                System.out.println(Arrays.toString(a));
//            }
//            System.out.println();
            if (!check2()) {
//                for (int[] a : container) {
//                    System.out.println(Arrays.toString(a));
//                }
//                System.out.println();
                X = true;
            }
            return;
        }

        for (int i = idx; i < num; i++) {
            if (!check2()) {
                if (type == 'B') {
                    if ((list.get(i)[0] % 2 == 0 && list.get(i)[1] % 2 == 0) ||
                            (list.get(i)[0] % 2 != 0 && list.get(i)[1] % 2 != 0)) {
                        container.add(list.get(i));
                        dfs(i + 1, 'B');
                        container.remove(container.size() - 1);
                    }
                } else {
                    if ((list.get(i)[0] % 2 != 0 && list.get(i)[1] % 2 == 0) ||
                            (list.get(i)[0] % 2 == 0 && list.get(i)[1] % 2 != 0)) {
                        container.add(list.get(i));
                        dfs(i + 1, 'W');
                        container.remove(container.size() - 1);
                    }
                }
            } else {
//                for (int[] a : container) {
//                    System.out.println(Arrays.toString(a));
//                }
//                System.out.println("wat");
                return;
            }
        }
    }

    static boolean check2() {
        if (container.size() < 2) return false;

        for (int i = 0; i < container.size() - 1; i++) {
            for (int j = i + 1; j < container.size(); j++) {
                if (Math.abs(container.get(i)[0] - container.get(j)[0]) ==
                        Math.abs(container.get(i)[1] - container.get(j)[1])) {
                    return true;
                }
            }
        }
        return false;
    }


    static boolean check() {
        for (int i = 0; i < start; i++) {
            graph[container.get(i)[0]][container.get(i)[1]] = 0;
        }

        boolean flag = false;

//        tmp1 = new boolean[n * 2];
//        tmp2 = new boolean[n * 2];
//
//        for (int i = 0; i < num; i++) {
//            if (graph[list.get(i)[0]][list.get(i)[1]] == 1) {
//                if (!tmp1[list.get(i)[0] + list.get(i)[1]] && !tmp2[list.get(i)[0] + (n - 1 - list.get(i)[1])]) {
//                    tmp1[list.get(i)[0] + list.get(i)[1]] = true;
//                    tmp2[list.get(i)[0] + (n - 1 - list.get(i)[1])] = true;
//                } else {
//                    flag = true;
//                    break;
//                }
//            }
//        }

        for (int i = 0; i < num; i++) {
            if (graph[list.get(i)[0]][list.get(i)[1]] == 1) {
                if (isAttackable(list.get(i)[0], list.get(i)[1])) {
                    flag = true;
                    break;
                }
            }
        }

//        loop:
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (graph[i][j] == 1) {
//                    if (isAttackable(i, j)) {
//                        flag = true;
//                        break loop;
//                    }
//                }
//            }
//        }

        if (!flag) {
//            System.out.println(Arrays.toString(tmp1));
//            System.out.println(Arrays.toString(tmp2));
            for (int[] y : graph) {
                System.out.println(Arrays.toString(y));
            }
            return true;
        } else {
            for (int i = 0; i < start; i++) {
                graph[container.get(i)[0]][container.get(i)[1]] = 1;
            }
            return false;
        }
    }

    static boolean isAttackable(int y, int x) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (graph[ny][nx] == 1) {
                    return true;
                }
                nx += dx[k];
                ny += dy[k];
            }
        }

        return false;
    }
}