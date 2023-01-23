import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k, ans;
    static int[] arr, nodeMap, familyTree;
    static List<Integer>[] nodesPerLevel;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        nodeMap = new int[1_000_001];
        familyTree = new int[1_000_001];
        nodesPerLevel = new List[1_000_001];

        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if (n == 0 && k == 0) break;

            arr = new int[n];
            ans = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            makeTree();
            findCousins(nodeMap[k]);
//            System.out.println(Arrays.toString(nodeMap).substring(0, 150));

            sb.append(ans).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    static void findCousins(int level) {
        int grandParent = familyTree[familyTree[k]];
        int parent = familyTree[k];

        for (int x : nodesPerLevel[level]) {
            if (x == k) continue;

            int curGrandParent = familyTree[familyTree[x]];
            int curParent = familyTree[x];
            if (curGrandParent == grandParent && curParent != parent) {
                ans++;
            }
        }

    }

    static void makeTree() {

        List<Integer> curParentList = new ArrayList<>();
        curParentList.add(arr[0]);
        familyTree[arr[0]] = 0;
        nodesPerLevel[0] = new ArrayList<>();
        nodesPerLevel[0].add(arr[0]);
        nodeMap[arr[0]] = 0;

        List<Integer> addedParentList = new ArrayList<>();
        int curParentIdx = 0;
        int maxParentIdx = 1;
        int level = 1;

        for (int i = 1; i < n; i++) {
            addedParentList.add(arr[i]);
            familyTree[arr[i]] = curParentList.get(curParentIdx);
            nodeMap[arr[i]] = level;
            if (i == n - 1 || arr[i] != arr[i + 1] - 1) {
                curParentIdx++;
                if (curParentIdx == maxParentIdx) {
                    curParentList.clear();
                    curParentList.addAll(addedParentList);
                    nodesPerLevel[level] = new ArrayList<>();
                    nodesPerLevel[level].addAll(addedParentList);
                    addedParentList.clear();
                    maxParentIdx = curParentList.size();
                    curParentIdx = 0;
                    level++;
                } else {
                    if (i == n - 1) {
                        nodesPerLevel[level] = new ArrayList<>();
                        nodesPerLevel[level].addAll(addedParentList);
                    }
                }
            }
        }
    }


}
