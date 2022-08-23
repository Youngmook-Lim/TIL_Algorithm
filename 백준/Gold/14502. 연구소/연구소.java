import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] lab;
    static List<Integer[]> zeros;
    static Stack<Integer[]> three;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab = new int[n][m];
        zeros = new ArrayList<>();
        three = new Stack<>();
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 0) {
                    zeros.add(new Integer[]{i, j});
                }
            }
        }

        combi(0);

        bw.write(total + "\n");
        bw.flush();
        bw.close();
        br.close();
    } // main


    static void bfs(int i, int j) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Integer[] tmp = q.poll();
            int x = tmp[1];
            int y = tmp[0];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && (lab[ny][nx] == 0 || lab[ny][nx] == 2)) {
                    visited[ny][nx] = true;
                    q.add(new Integer[]{ny, nx});
                }

            }

        }


    }

    static void combi(int idx) {
        if (three.size() == 3) {

            Stack<Integer[]> tmp = new Stack<>();
            for (int i = 0; i < 3; i++) {
                tmp.push(three.pop());
                lab[tmp.peek()[0]][tmp.peek()[1]] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (lab[i][j] == 2) {
                        bfs(i, j);
                    }
                }
            }


            int cnt = 0;
//        System.out.println(i + " " + j);
//        System.out.println(Arrays.deepToString(visited));

            for (int k = 0; k < n; k++) {
                for (int l = 0; l < m; l++) {
                    if (lab[k][l] == 0 && !visited[k][l]) {
                        cnt++;
                    }
                }
            }

            total = Integer.max(total, cnt);

            visited = new boolean[n][m];

            for (int i = 0; i < 3; i++) {
                three.push(tmp.pop());
                lab[three.peek()[0]][three.peek()[1]] = 0;
            }

//            for (Integer[] x : three) {
//                System.out.print(Arrays.toString(x) + " ");
//            }
//            System.out.println();
            return;
        }

        for (int i = idx; i < zeros.size(); i++) {
            three.push(zeros.get(i));
            combi(i + 1);
            three.pop();
        }
    }
}