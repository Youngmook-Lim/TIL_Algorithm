import java.util.*;

class Solution {
    
    int[] dist;
    List<Node>[] list;
    
    class Node implements Comparable<Node> {
        int v, e;
        Node(int v, int e) {
            this.v = v;
            this.e = e;
        }
        
        public int compareTo(Node n) {
            return this.e - n.e;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        list = new List[N + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int[] arr : road) {
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        
        dijkstra();
        
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
    
    public void dijkstra() {
        Queue<Node> pq = new PriorityQueue<>();
        
        pq.add(new Node(1, 0));
        dist[1] = 0;
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dist[cur.v] < cur.e) continue;
            
            for (Node next : list[cur.v]) {
                if (dist[next.v] > dist[cur.v] + next.e) {
                    dist[next.v] = dist[cur.v] + next.e;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
            
        }
        
    }
}