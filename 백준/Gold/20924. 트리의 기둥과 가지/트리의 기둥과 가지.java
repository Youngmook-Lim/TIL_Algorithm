import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int n, r;
    static List<Node>[] adj;
    static boolean[] visited;
    static int trunk, branch, giga;

    static class Node {
        int n, d;

        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "n=" + n +
                    ", d=" + d +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, d));
            adj[b].add(new Node(a, d));
        }


        findGiga(r, 0);
        findBranch(giga, 0);

        System.out.println(trunk + " " + branch);

        br.close();
    }

    static void findBranch(int node, int sum) {
        visited[node] = true;

        int cnt = 0;

        for (Node next : adj[node]) {
            if (visited[next.n]) continue;
            cnt++;
        }

        if (cnt == 0) {
            branch = Math.max(branch, sum);
            return;
        }

        for (Node next : adj[node]) {
            if (visited[next.n]) continue;
            findBranch(next.n, sum + next.d);
        }

    }

    static void findGiga(int node, int sum) {
        visited[node] = true;

        int cnt = 0;

        for (Node next : adj[node]) {
            if (visited[next.n]) continue;
            cnt++;
        }

        if (cnt != 1) {
            trunk = sum;
            giga = node;
        } else {
            for (Node next : adj[node]) {
                if (visited[next.n]) continue;
                findGiga(next.n, sum + next.d);
            }
        }

    }

}
