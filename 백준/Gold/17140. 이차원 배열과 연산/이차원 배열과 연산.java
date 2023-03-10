import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int r, c, k;
    static int t;
    static int[][] graph;
    static int rLength, cLength;
    static boolean flag;

    static class P implements Comparable<P> {
        int num, cnt;

        public P(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(P o) {
            if (this.cnt != o.cnt) {
                return this.cnt - o.cnt;
            }
            return this.num - o.num;
        }

        @Override
        public String toString() {
            return "P{" +
                    "num=" + num +
                    ", cnt=" + cnt +
                    '}';
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        t = 100;
        graph = new int[100][100];
        rLength = 3;
        cLength = 3;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (t-- >= 0) {
            if (checkSatisfy()) {
                flag = true;
                break;
            }
            char cmd = checkROrC();
            sortGraph(cmd);
        }

        if (flag) {
            System.out.println(100 - t - 1);
        } else {
            System.out.println(-1);
        }

        br.close();
    }

    static boolean checkSatisfy() {
        return graph[r][c] == k;
    }

    static void sortGraph(char cmd) {

        int max = 0;
        if (cmd == 'R') {
            for (int i = 0; i < cLength; i++) {
                int[] tmp = new int[101];
                List<P> list = new ArrayList<>();
                for (int j = 0; j < rLength; j++) {
                    int num = graph[i][j];
                    tmp[num]++;
                    graph[i][j] = 0;
                }

                for (int j = 1; j <= 100; j++) {
                    if (tmp[j] == 0) continue;
                    list.add(new P(j, tmp[j]));
                }

                Collections.sort(list);

                int idx = 0;
                for (P p : list) {
                    if (idx >= 100) break;
                    graph[i][idx++] = p.num;
                    graph[i][idx++] = p.cnt;
                }
                max = Math.max(idx, max);
            }
            rLength = max;
        } else {
            for (int i = 0; i < rLength; i++) {
                int[] tmp = new int[101];
                List<P> list = new ArrayList<>();
                for (int j = 0; j < cLength; j++) {
                    int num = graph[j][i];
                    tmp[num]++;
                    graph[j][i] = 0;
                }

                for (int j = 1; j <= 100; j++) {
                    if (tmp[j] == 0) continue;
                    list.add(new P(j, tmp[j]));
                }

                Collections.sort(list);

                int idx = 0;
                for (P p : list) {
                    if (idx >= 100) break;
                    graph[idx++][i] = p.num;
                    graph[idx++][i] = p.cnt;
                }
                max = Math.max(idx, max);
            }
            cLength = max;
        }
    }

    static char checkROrC() {
        if (cLength >= rLength) {
            return 'R';
        } else {
            return 'C';
        }
    }


}


