import java.util.*;

class Solution {
    
    int[] arr;
    int maxDiff;
    int N;
    boolean flag;
    
    public int[] solution(int n, int[] info) {
        arr = new int[11];
        N = n;

        dfs(N, 0L, info, 0);

        if (flag) {
            return arr;
        } else {
            return new int[]{-1};
        }
    }
    
    void dfs(int remaining, long visited, int[] info, int idx) {
        if (remaining == 0) {
            calcScores(info, visited, 0, 0);
            return;
        }

        for (int i = idx; i < 11; i++) {
            if ((visited & (1L << i)) == 0) {
                if (info[i] + 1 > remaining) {
                    calcScores(info, visited, i, remaining);
                } else {
                    dfs(remaining - info[i] - 1, visited | (1 << i), info, i + 1);
                }
            }
        }

    }

    void calcScores(int[] info, long visited, int idx, int remainder) {
        int apeachScore = 0;
        int ryanScore = 0;
        for (int i = 0; i < 11; i++) {
            if ((visited & (1 << i)) != 0) {
                ryanScore += 10 - i;
            } else {
                if (info[i] != 0) {
                    apeachScore += 10 - i;
                }
            }
        }
        if (ryanScore > apeachScore) {
            flag = true;
            int diff = ryanScore - apeachScore;
            if (diff > maxDiff) {
                maxDiff = diff;
                for (int i = 0; i < 11; i++) {
                    if ((visited & (1 << i)) != 0) {
                        arr[i] = info[i] + 1;
                    } else {
                        arr[i] = 0;
                    }
                }
                arr[idx] += remainder;
            } else if (diff == maxDiff) {
                int[] tmp = new int[11];
                for (int i = 0; i < 11; i++) {
                    if ((visited & (1 << i)) != 0) {
                        tmp[i] = info[i] + 1;
                    } else {
                        tmp[i] = 0;
                    }
                }
                tmp[idx] += remainder;

                boolean isChange = false;

                for (int i = 10; i >= 0; i--) {
                    if (tmp[i] > arr[i]) {
                        isChange = true;
                        break;
                    } else if (tmp[i] < arr[i]) {
                        break;
                    }
                }

                if (isChange) {
                    for (int i = 0; i < 11; i++) {
                        arr[i] = tmp[i];
                    }
                }
            }
        }

    }
}