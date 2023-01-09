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
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        mainTreeSet = new TreeSet<>();
        categoryTreeSets = new TreeSet[101];
//        for (int i = 0; i < 101; i++) {
//            categoryTreeSets[i] = new TreeSet<>();
//        }
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
            P cur = new P(p, l, g);
            mainTreeSet.add(cur);
            if (categoryTreeSets[g] == null) {
                categoryTreeSets[g] = new TreeSet<>();
            }
            categoryTreeSets[g].add(cur);
            pList[p] = cur;
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
                    P cur = new P(p, l, g);
                    mainTreeSet.add(cur);
                    if (categoryTreeSets[g] == null) {
                        categoryTreeSets[g] = new TreeSet<>();
                    }
                    categoryTreeSets[g].add(cur);
                    pList[p] = cur;
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
                        sb.append((categoryTreeSets[g].last().p)).append('\n');
                    } else {
                        sb.append((categoryTreeSets[g].first().p)).append('\n');
                    }
                    break;
                case "recommend2":
                    x = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        sb.append((mainTreeSet.last().p)).append('\n');
                    } else {
                        sb.append((mainTreeSet.first().p)).append('\n');
                    }
                    break;
                case "recommend3":
                    x = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        P tmp = new P(0, l, 0);
                        P higher = mainTreeSet.ceiling(tmp);
                        if (higher == null) {
                            sb.append((-1)).append('\n');
                        } else {
                            sb.append((higher.p)).append('\n');
                        }
                    } else {
                        P tmp = new P(0, l, 0);
                        P lower = mainTreeSet.floor(tmp);
                        if (lower == null) {
                            sb.append((-1)).append('\n');
                        } else {
                            sb.append((lower.p)).append('\n');
                        }
                    }
                    break;
            }
        }

        System.out.println(sb);

        br.close();
    }

}
