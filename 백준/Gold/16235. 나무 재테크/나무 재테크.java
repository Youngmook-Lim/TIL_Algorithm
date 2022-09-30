import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k;
    static int[][] addSoil;
    static int[][] graph;
    static Queue<Tree> trees;
    static Queue<Tree> live;
    static Queue<Tree> dead;

    static class Tree implements Comparable<Tree> {
        int x, y, age;

        public Tree(int y, int x, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age, o.age);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        addSoil = new int[n][n];
        graph = new int[n][n];
        trees = new PriorityQueue<>();
        live = new LinkedList<>();
        dead = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                addSoil[i][j] = Integer.parseInt(st.nextToken());
                graph[i][j] = 5;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            trees.add(new Tree(y, x, z));
        }


        while (k > 0) {
            springNSummer();
            autumn();
            winter();
            k--;
        }

        System.out.println(trees.size());

        br.close();
    }

    static void springNSummer() {
        while (!trees.isEmpty()) {
            Tree t = trees.poll();
            if (t.age <= graph[t.y][t.x]) {
                graph[t.y][t.x] -= t.age;
                t.age++;
                live.add(t);
            } else {
                dead.add(t);
            }
        }
        while (!dead.isEmpty()) {
            Tree t = dead.poll();
            graph[t.y][t.x] += t.age / 2;
        }
    }

    static void autumn() {
        int[] dx = {1, -1, 1, -1, 0, 0, 1, -1};
        int[] dy = {1, -1, -1, 1, 1, -1, 0, 0};
        while (!live.isEmpty()) {
            Tree t = live.poll();
            if (t.age % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int nx = t.x + dx[j];
                    int ny = t.y + dy[j];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    trees.add(new Tree(ny, nx, 1));
                }
            }
            trees.add(t);
        }
    }

    static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] += addSoil[i][j];
            }
        }
    }

}