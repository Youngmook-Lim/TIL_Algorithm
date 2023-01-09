import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static TreeSet<P> mainTreeSet;
    static TreeSet<P>[] categoryTreeSets;
    static P[] pList;

    static class P implements Comparable<P> {
        int p, l, g;

        public P(int p, int l, int g) {
            this.p = p;
            this.l = l;
            this.g = g;
        }

        @Override
        public int compareTo(P o) {
            if (this.l != o.l) {
                return this.l - o.l;
            }
            return this.p - o.p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        mainTreeSet = new TreeSet<>();
        categoryTreeSets = new TreeSet[101];
        for (int i = 0; i < 101; i++) {
            categoryTreeSets[i] = new TreeSet<>();
        }
        pList = new P[100001];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            if (pList[p] != null) {
                mainTreeSet.remove(pList[p]);
                categoryTreeSets[pList[p].g].remove(pList[p]);
            }
            mainTreeSet.add(new P(p, l, g));
            categoryTreeSets[g].add(new P(p, l, g));
            pList[p] = new P(p, l, g);
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int p, l, g, x;
            switch (cmd) {
                case "add":
                    p = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());
                    g = Integer.parseInt(st.nextToken());
                    if (pList[p] != null) {
                        mainTreeSet.remove(pList[p]);
                        categoryTreeSets[pList[p].g].remove(pList[p]);
                    }
                    mainTreeSet.add(new P(p, l, g));
                    categoryTreeSets[g].add(new P(p, l, g));
                    pList[p] = new P(p, l, g);
                    break;
                case "solved":
                    p = Integer.parseInt(st.nextToken());
                    mainTreeSet.remove(pList[p]);
                    categoryTreeSets[pList[p].g].remove(pList[p]);
                    pList[p] = null;
                    break;
                case "recommend":
                    g = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        System.out.println((categoryTreeSets[g].last().p));
                    } else {
                        System.out.println((categoryTreeSets[g].first().p));
                    }
                    break;
                case "recommend2":
                    x = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        System.out.println((mainTreeSet.last().p));
                    } else {
                        System.out.println((mainTreeSet.first().p));
                    }
                    break;
                case "recommend3":
                    x = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        P tmp = new P(0, l, 0);
                        P higher = mainTreeSet.ceiling(tmp);
                        if (higher == null) {
                            System.out.println((-1));
                        } else {
                            System.out.println((higher.p));
                        }
                    } else {
                        P tmp = new P(0, l, 0);
                        P lower = mainTreeSet.floor(tmp);
                        if (lower == null) {
                            System.out.println((-1));
                        } else {
                            System.out.println((lower.p));
                        }
                    }
                    break;
            }
        }


        br.close();
    }

}
