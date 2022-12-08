import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n, m;
    static int[] arr;

    static class P {
        int max, min;

        public P(int max, int min) {
            this.max = max;
            this.min = min;
        }

        @Override
        public String toString() {
            return "P{" +
                    "max=" + max +
                    ", min=" + min +
                    '}';
        }
    }

    static class Sgmt {
        P[] resultTree;
        int[] inputTree;
        int level;
        int size;

        Sgmt(int[] inputTree) {
            this.inputTree = inputTree;
            this.level = (int) (Math.ceil(Math.log(inputTree.length) / Math.log(2)) + 1);
            this.size = (int) Math.pow(2, this.level);
            this.resultTree = new P[this.size];

            this.make(0, this.inputTree.length - 1, 1);
        }

        P make(int start, int end, int treeIdx) {
            if (start == end) {
                int num = this.inputTree[start];
                this.resultTree[treeIdx] = new P(num, num);
                return this.resultTree[treeIdx];
            }

            int mid = (start + end) / 2;
            P leftResult = make(start, mid, treeIdx * 2);
            P rightResult = make(mid + 1, end, treeIdx * 2 + 1);

            this.resultTree[treeIdx] = new P(Math.max(leftResult.max, rightResult.max), Math.min(leftResult.min, rightResult.min));
            return this.resultTree[treeIdx];
        }

        P getRange(int start, int end, int treeIdx, int rangeStart, int rangeEnd) {
            if (rangeStart > end || rangeEnd < start) {
                return new P(Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
            if (rangeStart <= start && rangeEnd >= end) {
                return this.resultTree[treeIdx];
            }

            int mid = (start + end) / 2;
            P leftResult = getRange(start, mid, treeIdx * 2, rangeStart, rangeEnd);
            P rightResult = getRange(mid + 1, end, treeIdx * 2 + 1, rangeStart, rangeEnd);

            return new P(Math.max(leftResult.max, rightResult.max), Math.min(leftResult.min, rightResult.min));
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Sgmt sgmt = new Sgmt(arr);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            P p = sgmt.getRange(0, sgmt.inputTree.length - 1, 1, start, end);
            sb.append(p.min).append(' ').append(p.max).append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}
