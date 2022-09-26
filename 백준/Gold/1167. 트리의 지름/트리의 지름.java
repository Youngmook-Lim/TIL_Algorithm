import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int v, max, maxIdx;
    static boolean[] visited;

    static class Node {
        int num, dist;

        Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", dist=" + dist +
                    '}';
        }
    }

    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        v = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[v + 1];

        for (int i = 1; i < v + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int curNode = Integer.parseInt(st.nextToken());
            while (true) {
                int nextNode = Integer.parseInt(st.nextToken());
                if (nextNode != -1) {
                    int nextDist = Integer.parseInt(st.nextToken());
                    list[curNode].add(new Node(nextNode, nextDist));
                } else {
                    break;
                }
            }
        }

        visited = new boolean[v + 1];
        dfs(1, 0);
        visited = new boolean[v + 1];
        dfs(maxIdx, 0);

        System.out.println(max);

        br.close();
    }

    static void dfs(int start, int total) {

        if (total > max) {
            max = total;
            maxIdx = start;
        }

        for (int i = 0; i < list[start].size(); i++) {
            Node next = list[start].get(i);

            if (!visited[next.num]) {
                visited[start] = true;

                dfs(next.num, total + next.dist);
            }
        }


    }


}
