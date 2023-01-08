import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static Node[] tree;
    static int[][] dp;
    static boolean[] visited;

    static class Node {
        int n;
        Node next;

        public Node(int n, Node next) {
            this.n = n;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "n=" + n +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        tree = new Node[n + 1];
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u] = new Node(v, tree[u]);
            tree[v] = new Node(u, tree[v]);
        }

        getEarlyAdaptors(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));

        br.close();
    }

    static void getEarlyAdaptors(int cur) {

        visited[cur] = true;
        dp[cur][0] = 0;
        dp[cur][1] = 1;

        for (Node next = tree[cur]; next != null; next = next.next) {
            if (visited[next.n]) continue;
            getEarlyAdaptors(next.n);
            dp[cur][0] += dp[next.n][1];
            dp[cur][1] += Math.min(dp[next.n][0], dp[next.n][1]);
        }

    }
}
