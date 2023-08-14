import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int T;
    static int a, b;
    static Queue<P> q;

    static class P {
        int n;
        List<Character> list;

        public P(int n, List<Character> list) {
            this.n = n;
            this.list = list;
        }
    }

    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            q = new ArrayDeque<>();
            visited = new boolean[10001];

            q.add(new P(a, new ArrayList<>()));

            while (!q.isEmpty()) {
                P p = q.poll();

                if (p.n == b) {
                    for (Character x : p.list) {
                        sb.append(x);
                    }
                    sb.append('\n');
                    break;
                }

                P resultD = doD(p);
                P resultS = doS(p);
                P resultL = doL(p);
                P resultR = doR(p);

                if (resultD != null) {
                    q.add(resultD);
                }
                if (resultS != null) {
                    q.add(resultS);
                }
                if (resultL != null) {
                    q.add(resultL);
                }
                if (resultR != null) {
                    q.add(resultR);
                }

            }
        }

        System.out.println(sb);

        br.close();

    }

    static List<Character> getList(char type, List<Character> list) {
        List<Character> resultList = new ArrayList<>(list);
        resultList.add(type);
        return resultList;
    }

    static boolean authenticate(int num) {
        if (visited[num]) return true;
        visited[num] = true;
        return false;
    }

    static P doD(P p) {
        int resultNum = (2 * p.n) % 10000;
        if (authenticate(resultNum)) return null;
        return new P(resultNum, getList('D', p.list));
    }

    static P doS(P p) {

        int resultNum = p.n - 1;
        if (resultNum == -1) {
            resultNum += 10000;
        }
        if (authenticate(resultNum)) return null;

        return new P(resultNum, getList('S', p.list));
    }

    static P doL(P p) {

        int left = p.n / 1000;
        int resultNum = p.n * 10 - left * 10000 + left;
        if (authenticate(resultNum)) return null;

        return new P(resultNum, getList('L', p.list));
    }

    static P doR(P p) {

        int right = p.n % 10;
        int resultNum = p.n / 10 + right * 1000;
        if (authenticate(resultNum)) return null;
        
        return new P(resultNum, getList('R', p.list));
    }


}