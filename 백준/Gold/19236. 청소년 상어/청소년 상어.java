import java.util.*;
import java.io.*;

class Main {

    static int[][] graph;
    static Fish[] fishes;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int ans, sx, sy, sd;


    static class Fish {
        int n, x, y, dir;
        boolean isAlive;

        public Fish(int n, int x, int y, int dir, boolean isAlive) {
            this.n = n;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.isAlive = isAlive;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        graph = new int[4][4];
        fishes = new Fish[17];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken()) - 1;
                graph[i][j] = a;
                fishes[a] = new Fish(a, j, i, b, true);
            }
        }

        eatFirstFish();
        dfs(ans);

        System.out.println(ans);

        br.close();

    }

    static void dfs(int eat) {
        ans = Math.max(ans, eat);
        int[][] graphCopy = new int[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(graph[i], 0, graphCopy[i], 0, 4);
        }
        Fish[] fishesCopy = new Fish[17];
        for (int i = 1; i < 17; i++) {
            fishesCopy[i] = new Fish(fishes[i].n, fishes[i].x, fishes[i].y, fishes[i].dir, fishes[i].isAlive);
        }
        
        moveFish();

        for (int i = 1; i <= 3; i++) {
            int nx = sx + dx[sd] * i;
            int ny = sy + dy[sd] * i;

            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || graph[ny][nx] == 0) continue;

            int orgSd = sd;
            int orgSx = sx;
            int orgSy = sy;
            int eatNum = graph[ny][nx];
            Fish targetFish = fishes[eatNum];
            fishes[eatNum].isAlive = false;
//            targetFish.isAlive = false;
            graph[sy][sx] = 0;
            sd = targetFish.dir;
            sx = targetFish.x;
            sy = targetFish.y;
            graph[ny][nx] = -1;

            dfs(eat + targetFish.n);

            fishes[eatNum].isAlive = true;
//            targetFish.isAlive = true;
            sd = orgSd;
            sx = orgSx;
            sy = orgSy;
            graph[sy][sx] = -1;
            graph[ny][nx] = targetFish.n;

        }

        for (int i = 0; i < 4; i++) {
            System.arraycopy(graphCopy[i], 0, graph[i], 0, 4);
        }
        for (int i = 1; i < 17; i++) {
            fishes[i] = new Fish(fishesCopy[i].n, fishesCopy[i].x, fishesCopy[i].y, fishesCopy[i].dir, fishesCopy[i].isAlive);
        }
    }

    static void moveFish() {
        for (int i = 1; i < 17; i++) {
            Fish fish = fishes[i];
            if (!fish.isAlive) continue;
            for (int k = 0; k < 8; k++) {
                int nx = fish.x + dx[(fish.dir + k) % 8];
                int ny = fish.y + dy[(fish.dir + k) % 8];

                if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || graph[ny][nx] == -1) continue;
                fish.dir = (fish.dir + k) % 8;
                if (graph[ny][nx] == 0) {
                    graph[fish.y][fish.x] = 0;
                    fish.x = nx;
                    fish.y = ny;
                    graph[ny][nx] = fish.n;
                } else {
                    Fish swapFish = fishes[graph[ny][nx]];
                    int tmp = graph[fish.y][fish.x];
                    graph[fish.y][fish.x] = graph[ny][nx];
                    graph[ny][nx] = tmp;
                    swapFish.x = fish.x;
                    swapFish.y = fish.y;
                    fish.x = nx;
                    fish.y = ny;
                }
                break;
            }
        }
    }

    static void eatFirstFish() {
        int firstFish = graph[0][0];
        sd = fishes[firstFish].dir;
        sx = sy = 0;
        fishes[firstFish].isAlive = false;
        ans += firstFish;
        graph[0][0] = -1;
    }

}