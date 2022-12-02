import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int n, m, k;
    static long[] arr;
    static final int MOD = 1_000_000_007;

    static class SegmentTree {
        long[] inputTree;
        long[] resultTree;
        int treeIdx = 1;
        int level;
        int size;
        int inputStart = 0;
        int inputEnd;
        int inputSize;

        SegmentTree(long[] inputTree) {
            this.inputTree = inputTree;
            this.inputSize = inputTree.length;
            this.inputEnd = inputSize - 1;
            this.level = (int) (Math.ceil(Math.log(this.inputSize + 1) / Math.log(2)) + 1);
            this.size = (int) Math.pow(2, this.level);
            this.resultTree = new long[this.size];

            this.make(this.inputStart, this.inputEnd, this.treeIdx);
        }

        long make(int start, int end, int treeIdx) {
            if (start == end) {
                this.resultTree[treeIdx] = this.inputTree[start];
                return this.resultTree[treeIdx];
            }

            int mid = (start + end) / 2;
            long leftResult = make(start, mid, treeIdx * 2);
            long rightResult = make(mid + 1, end, treeIdx * 2 + 1);

            this.resultTree[treeIdx] = (leftResult * rightResult) % MOD;
            return this.resultTree[treeIdx];
        }

        long update(int start, int end, int treeIdx, int updateIdx, long updateValue) {
            if (updateIdx < start || updateIdx > end) {
                return this.resultTree[treeIdx];
            }

            if (start == end) {
                this.inputTree[updateIdx] = updateValue;
                this.resultTree[treeIdx] = updateValue;
                return this.resultTree[treeIdx];
            }

            int mid = (start + end) / 2;
            long leftResult = update(start, mid, treeIdx * 2, updateIdx, updateValue);
            long rightResult = update(mid + 1, end, treeIdx * 2 + 1, updateIdx, updateValue);

            this.resultTree[treeIdx] = (leftResult * rightResult) % MOD;
            return this.resultTree[treeIdx];
        }

        long getRange(int start, int end, int treeIdx, int rangeStart, int rangeEnd) {
            if (rangeStart > end || rangeEnd < start) {
                return 1;
            }

            if (rangeStart <= start && rangeEnd >= end) {
                return this.resultTree[treeIdx];
            }

            int mid = (start + end) / 2;
            long leftResult = getRange(start, mid, treeIdx * 2, rangeStart, rangeEnd);
            long rightResult = getRange(mid + 1, end, treeIdx * 2 + 1, rangeStart, rangeEnd);

            return (leftResult * rightResult) % MOD;

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree sgmt = new SegmentTree(arr);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                sgmt.update(sgmt.inputStart, sgmt.inputEnd, sgmt.treeIdx, b - 1, c);
            } else {
                int c = Integer.parseInt(st.nextToken());
                long result = sgmt.getRange(sgmt.inputStart, sgmt.inputEnd, sgmt.treeIdx, b - 1, c - 1);
                sb.append(result).append('\n');
            }
        }

        System.out.println(sb);

        br.close();
    }

}
