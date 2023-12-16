import java.util.*;

class Solution {

    int n, cnt;
    List<Integer> list;
    int[] nums;

    public int solution(int[] number) {

        n = number.length;
        nums = number;
        list = new ArrayList<>();
        cnt = 0;

        dfs(0, 0);

        return cnt;
    }

    void dfs(int idx, int depth) {
        if (depth == 3) {
            int total = getTotal(list);
            if (total == 0) {
                cnt++;
            }
        }

        for (int i = idx; i < n; i++) {
            list.add(nums[i]);
            dfs(i + 1, depth + 1);
            list.remove(list.size() - 1);
        }
    }

    int getTotal(List<Integer> list) {
        int sum = 0;
        for (int x : list) {
            sum += x;
        }
        return sum;
    }
}

