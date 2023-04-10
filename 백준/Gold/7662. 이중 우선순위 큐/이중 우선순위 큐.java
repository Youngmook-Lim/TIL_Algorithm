import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {

    static int T, k, idx;

    static class Num implements Comparable<Num> {
        int n, id;

        public Num(int n, int id) {
            this.n = n;
            this.id = id;
        }

        @Override
        public int compareTo(Num o) {
            if (this.n != o.n) {
                return Integer.compare(this.n, o.n);
            }
            return Integer.compare(this.id, o.id);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            k = Integer.parseInt(br.readLine());
            // idx = 0;
            TreeSet<Num> treeSet = new TreeSet<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (cmd == 'I') {
                    treeSet.add(new Num(n, idx++));
                } else {
                    if (treeSet.isEmpty()) continue;

                    if (n == 1) {
                        treeSet.pollLast();
                    } else {
                        treeSet.pollFirst();
                    }
                }
            }

            if (treeSet.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(treeSet.last().n).append(' ').append(treeSet.first().n);
            }
            sb.append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}

