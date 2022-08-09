import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<int[]> pqMax;
    static PriorityQueue<int[]> pqMin;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());

            pqMax = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o2[0] > o1[0]) {
                        return 1;
                    } else if (o2[0] == o1[0]) {
                        return 0;
                    } else {
                        return -1;
                    }
//                    return o2[0] - o1[0];
                }
            });
            pqMin = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o2[0] < o1[0]) {
                        return 1;
                    } else if (o2[0] == o1[0]) {
                        return 0;
                    } else {
                        return -1;
                    }
//                    return o1[0] - o2[0];
                }
            });

            visited = new boolean[k];

            for (int i = 0; i < k; i++) {
//                System.out.println(Arrays.deepToString(pqMin.toArray()));
//                System.out.println(Arrays.deepToString(pqMax.toArray()));
                StringTokenizer st = new StringTokenizer(br.readLine());
                String input = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (input.equals("I")) {
                    int[] tmp = new int[]{
                            num, i
                    };
//                    int[] tmp2 = new int[]{
//                            -num, i
//                    };

                    pqMin.add(tmp);
                    pqMax.add(tmp);
                    visited[i] = true;

                } else {
                    if (num == -1) {
                        while (!pqMin.isEmpty() && !visited[pqMin.peek()[1]]) {
                            pqMin.poll();
                        }
                        if (!pqMin.isEmpty()) {
                            visited[pqMin.peek()[1]] = false;
                            pqMin.poll();
                        }
                    } else {
                        while (!pqMax.isEmpty() && !visited[pqMax.peek()[1]]) {
                            pqMax.poll();
                        }
                        if (!pqMax.isEmpty()) {
                            visited[pqMax.peek()[1]] = false;
                            pqMax.poll();
                        }
                    }
                }

            }
            while (!pqMin.isEmpty() && !visited[pqMin.peek()[1]]) {
                pqMin.poll();
            }
            while (!pqMax.isEmpty() && !visited[pqMax.peek()[1]]) {
                pqMax.poll();
            }

            if (pqMin.isEmpty() || pqMax.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(pqMax.peek()[0] + " " + pqMin.peek()[0]);
            }
        }
        br.close();
    }
}

