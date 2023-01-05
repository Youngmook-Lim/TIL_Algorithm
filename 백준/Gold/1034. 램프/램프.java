import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 1. dfs 돌리니까 시간초과 남
 * 2. 패턴을 생각해 봄
 * 3. 행단위로 똑같이 생긴것들만 마지막에 같이 켜지던지 할 수 있음
 * 4. 패턴 같은거 중 가장 많은거 갖고 : k보다 0갯수가 많으면 안되고, 0개수 초과하는 k가 짝수이어야 함
 * */
public class Main {

    static int n, m, k, max, ans;
    static String maxString;
    static Map<String, Integer> map;
    static Queue<P> pq;

    static class P {
        String str;
        int cnt;

        public P(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        pq = new PriorityQueue<>(new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                return o2.cnt - o1.cnt;
            }
        });

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        for (String x : map.keySet()) {
            pq.add(new P(x, map.get(x)));
        }

        k = Integer.parseInt(br.readLine());

        while (!pq.isEmpty()) {
            P p = pq.poll();
            int zeros = cntZero(p.str);
            if (zeros > k) continue;
            int zerosMod = zeros % 2;
            int kMod = k % 2;
            if (zerosMod == kMod) {
                ans = p.cnt;
                break;
            }
        }

        System.out.println(ans);

        br.close();
    }

    static int cntZero(String str) {
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') total++;
        }
        return total;
    }


}

