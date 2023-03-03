import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {

    static class Num implements Comparable<Num> {
        long number;
        int cnt;

        public Num(long number, int cnt) {
            this.number = number;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Num o) {
            if (this.cnt != o.cnt) {
                return Integer.compare(o.cnt, this.cnt);
            }
            return Long.compare(this.number, o.number);
        }

        @Override
        public String toString() {
            return "Num{" +
                    "number=" + number +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        TreeSet<Num> ts = new TreeSet<>();
        Map<Long, Num> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long number = Long.parseLong(br.readLine());
            if (map.containsKey(number)) {
                Num num = map.get(number);
                ts.remove(num);
                num.cnt++;
                ts.add(num);
            } else {
                Num num = new Num(number, 1);
                map.put(number, num);
                ts.add(num);
            }
        }

        System.out.println(ts.first().number);

        br.close();
    }

}


