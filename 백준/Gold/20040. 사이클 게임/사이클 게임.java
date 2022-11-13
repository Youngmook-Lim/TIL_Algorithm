import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * -- Union Find Algorithm
 * 1. makeSet()을 통해 각 집합의 대표자를 본인으로 설정하고
 * 2. 입력이 주어질때마다 대표자 확인하고, 같지 않으면 union
 * 3. 같으면 싸이클이므로 종료
 * */

public class Main {

    static int n, m;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        makeSet();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int parentA = findSet(a);
            int parentB = findSet(b);
//            System.out.println(parentA + " " + parentB);

            if (parentA == parentB) {
                System.out.println(i + 1);
                return;
            } else {
                union(parentA, parentB);
            }
        }
        System.out.println(0);

        br.close();
    }

    static void makeSet() {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
    }

    static int findSet(int x) {
        if (p[x] != x) {
            p[x] = findSet(p[x]);
        }
        return p[x];
    }

    static void union(int x, int y) {
        if (x > y) {
            p[x] = y;
        } else {
            p[y] = x;
        }
    }


}

