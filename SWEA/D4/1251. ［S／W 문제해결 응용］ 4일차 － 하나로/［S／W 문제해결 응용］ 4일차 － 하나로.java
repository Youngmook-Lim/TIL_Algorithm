import java.io.*;
import java.util.*;

public class Solution {
    static long ans;
    static int n, pick;
    static double e;
    static int[] x, y;

    static class Node implements Comparable<Node> {
        int v;
        long dist;

        public Node(int v, long dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    static boolean[] visited;
    static List<List<Node>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            ans = 0;
            pick = 0;
            n = Integer.parseInt(br.readLine());
            x = new int[n];
            y = new int[n];
            visited = new boolean[n];
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }
            e = Double.parseDouble(br.readLine());


            for (int i = 0; i < n - 1; i++) {
                for (int j = i; j < n; j++) {
                    int startX = x[i];
                    int startY = y[i];
                    int endX = x[j];
                    int endY = y[j];
                    long dist = (long) (Math.pow(Math.abs(startX - endX), 2) + Math.pow(Math.abs(startY - endY), 2));

                    list.get(i).add(new Node(j, dist));
                    list.get(j).add(new Node(i, dist));
                }
            }

            Queue<Node> q = new PriorityQueue<>();
            visited[0] = true;
            q.addAll(list.get(0));
            while (pick < n - 1) {
                Node node = q.poll();

                if (visited[node.v]) continue;
                visited[node.v] = true;

                ans += node.dist;
                q.addAll(list.get(node.v));
                pick++;
            }

            ans = Math.round(ans * e);

            bw.write("#" + t + " " + ans + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }


}