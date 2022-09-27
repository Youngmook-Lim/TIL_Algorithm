import java.io.*;
import java.util.*;

public class Main {

    static int ans;
    static int[][][] box, stackedBox;
    static boolean[][][] visitedBox;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static List<Integer> listStackOrder, listSpinOrder;
    static boolean[] visited;

    static class P {
        int x, y, z;

        P(int z, int y, int x) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        ans = Integer.MAX_VALUE;
        box = new int[5][5][5];
        stackedBox = new int[5][5][5];
        visited = new boolean[5];
        listStackOrder = new ArrayList<>();
        listSpinOrder = new ArrayList<>();
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < 5; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 5; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        dfsStack(0);

        if (ans == Integer.MAX_VALUE) {
            bw.write(-1 + "\n");
        } else {
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfsStack(int depth) {
        if (depth == 5) {
            dfsSpin(0);
//            System.out.println(listStackOrder);
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (!visited[i]) {
                visited[i] = true;
                listStackOrder.add(i);
                dfsStack(depth + 1);
                listStackOrder.remove(listStackOrder.size() - 1);
                visited[i] = false;
            }
        }

    }

    static void dfsSpin(int depth) {
        if (depth == 5) {
            stackNspin();
//            System.out.println(listSpinOrder);
            return;
        }

        for (int i = 0; i < 4; i++) {
            listSpinOrder.add(i);
            dfsSpin(depth + 1);
            listSpinOrder.remove(listSpinOrder.size() - 1);
        }
    }

    static void stackNspin() {
        for (int k = 0; k < 5; k++) {
            int spin = listSpinOrder.get(k);
            switch (spin) {
                case 0:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            stackedBox[listStackOrder.get(k)][i][j] = box[k][i][j];
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            stackedBox[listStackOrder.get(k)][j][4 - i] = box[k][i][j];
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            stackedBox[listStackOrder.get(k)][4 - i][4 - j] = box[k][i][j];
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            stackedBox[listStackOrder.get(k)][4 - j][i] = box[k][i][j];
                        }
                    }
                    break;
            }


        }
        
        bfs();

    }

    static void bfs() {
        if (stackedBox[0][0][0] == 0 || stackedBox[4][4][4] == 0) return;

        visitedBox = new boolean[5][5][5];
        Queue<P> q = new LinkedList<>();
        q.add(new P(0, 0, 0));
        visitedBox[0][0][0] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int a = 0; a < len; a++) {
                P p = q.poll();
                if (p.x == 4 && p.y == 4 && p.z == 4) {
                    ans = Math.min(ans, cnt);
                    return;
                }

                for (int l = 0; l < 6; l++) {
                    int nx = p.x + dx[l];
                    int ny = p.y + dy[l];
                    int nz = p.z + dz[l];

                    if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5
                            || stackedBox[nz][ny][nx] == 0 || visitedBox[nz][ny][nx]) continue;

                    visitedBox[nz][ny][nx] = true;
                    q.add(new P(nz, ny, nx));

                }
            }
            cnt++;
        }
    }


}
