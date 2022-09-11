import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, tmp, ans;
    static List<List<Node>> graph;
    static List<Integer> radius;

    static class Node {
        int num, dist;

        Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ans = 0;
        tmp = 0;
        graph = new ArrayList<>();
        radius = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph.get(parent).add(new Node(child, distance));
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                dfs(graph.get(i).get(j).num, graph.get(i).get(j).dist);
                radius.add(tmp);
                tmp = 0;
            }
            if (radius.isEmpty()) continue;

            if (radius.size() == 1) {
                ans = Math.max(ans, radius.get(0));
            } else {
                radius.sort(Collections.reverseOrder());
                ans = Math.max(ans, radius.get(0) + radius.get(1));
            }
            radius.clear();
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start, int sum) {
        if (graph.get(start).isEmpty()) {
            tmp = Math.max(tmp, sum);
            return;
        }

        for (int i = 0; i < graph.get(start).size(); i++) {
            dfs(graph.get(start).get(i).num, sum + graph.get(start).get(i).dist);
        }
    }


}