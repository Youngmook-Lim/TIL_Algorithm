import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<List<Integer>> nodes;
    static List<Integer> roots;
    static int[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }
        roots = new ArrayList<>();
        visited = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input == -1) {
                roots.add(i);
            } else {
                nodes.get(i).add(input);
                nodes.get(input).add(i);
            }
        }

        m = Integer.parseInt(br.readLine());

        for (int i : roots) {
            dfs(i);
            if (visited[i] != 2) {
                dfsCheck(i, i);
            }
        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfsCheck(int start, int root) {
        visited[start] = 2;

        int tmp = 0;
        for (int x : nodes.get(start)) {
            if (visited[x] != 2) {
                tmp++;
            }
        }
        if (tmp == 0) {
            cnt++;
        } else {
            for (int x : nodes.get(start)) {
                if (visited[x] != 2) {
                    dfsCheck(x, root);
                }
            }
        }
    }

    static void dfs(int start) {
        visited[start] = 1;
        if (start == m) {
            cut(start);
        }
        for (int x : nodes.get(start)) {
            if (visited[x] == 0) {
                dfs(x);
            }
        }
    }

    static void cut(int start) {
        visited[start] = 2;

        for (int x : nodes.get(start)) {
            if (visited[x] == 0) {
                cut(x);
            }
        }
    }
}

