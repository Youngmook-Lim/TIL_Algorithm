import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    static int n, m, k;
    static long[] arr;

    static class SegmentTree {
        long[] inputTree;
        int inputTreeLength;
        long[] resultTree;
        int inputStart = 0;
        int inputEnd;
        int level = 0;
        int size = 0;
        int treeIdx = 1;

        SegmentTree(long[] inputTree) {
            this.inputTreeLength = inputTree.length;
            this.inputEnd = inputTreeLength - 1;
            this.inputTree = new long[this.inputTreeLength];
            for (int i = 0; i < this.inputTreeLength; i++) {
                this.inputTree[i] = inputTree[i];
            }
            this.level = (int) (Math.ceil(Math.log(this.inputTreeLength) / Math.log(2)) + 1);
            this.size = (int) Math.pow(2, this.level);
            this.resultTree = new long[size];

            this.make(this.inputStart, this.inputEnd, this.treeIdx);
        }

        long make(int inputStart, int inputEnd, int treeIdx) {
            if (inputStart == inputEnd) {
                this.resultTree[treeIdx] = this.inputTree[inputStart];
                return this.resultTree[treeIdx];
            }

            int inputMid = (inputStart + inputEnd) / 2;

            long leftResult = make(inputStart, inputMid, treeIdx * 2);
            long rightResult = make(inputMid + 1, inputEnd, treeIdx * 2 + 1);

            this.resultTree[treeIdx] = leftResult + rightResult;
            return this.resultTree[treeIdx];
        }

        long getRange(int inputStart, int inputEnd, int treeIdx, int rangeStart, int rangeEnd) {
            if (rangeStart > inputEnd || rangeEnd < inputStart) return 0;

            if (rangeStart <= inputStart && rangeEnd >= inputEnd) {
                return resultTree[treeIdx];
            }

            int inputMid = (inputStart + inputEnd) / 2;

            long leftResult = getRange(inputStart, inputMid, treeIdx * 2, rangeStart, rangeEnd);
            long rightResult = getRange(inputMid + 1, inputEnd, treeIdx * 2 + 1, rangeStart, rangeEnd);

            return leftResult + rightResult;
        }

        long update(int inputStart, int inputEnd, int treeIdx, int updateIdx) {
            if (updateIdx < inputStart || updateIdx > inputEnd) {
                return this.resultTree[treeIdx];
            }

            if (inputStart == inputEnd) {
                this.resultTree[treeIdx] = this.inputTree[inputStart];
                return this.resultTree[treeIdx];
            }

            int inputMid = (inputStart + inputEnd) / 2;

            long leftResult = update(inputStart, inputMid, treeIdx * 2, updateIdx);
            long rightResult = update(inputMid + 1, inputEnd, treeIdx * 2 + 1, updateIdx);

            this.resultTree[treeIdx] = leftResult + rightResult;
            return this.resultTree[treeIdx];
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
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree sgmt = new SegmentTree(arr);

//        System.out.println(Arrays.toString(sgmt.resultTree));

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                sgmt.inputTree[b - 1] = c;
                sgmt.update(sgmt.inputStart, sgmt.inputEnd, sgmt.treeIdx, b - 1);
            } else {
                int c = Integer.parseInt(st.nextToken());
                long ans = sgmt.getRange(sgmt.inputStart, sgmt.inputEnd, sgmt.treeIdx, b - 1, c - 1);
                sb.append(ans).append('\n');
            }
        }

        System.out.println(sb);

        br.close();
    }


}
