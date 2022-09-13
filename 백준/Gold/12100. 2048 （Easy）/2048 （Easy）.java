import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static int[][] graph;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth) {
        if (depth == 5) {
            check();
            return;
        }

        for (int i = 0; i < 4; i++) {
            list.add(i);
            dfs(depth + 1);
            list.remove(list.size() - 1);
        }

    }

    // 0 : UP / 1 : DOWN / 2 : RIGHT / 3 : LEFT

    static void check() {
        int[][] tmpGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmpGraph[i][j] = graph[i][j];
            }
        }

        boolean flag = false;
        for (int k = 0; k < 5; k++) {
            int dir = list.get(k);
            switch (dir) {
                case 0:
                    for (int i = 0; i < n; i++) {
                        flag = false;
                        for (int j = 0; j < n; j++) {
                            if (tmpGraph[j][i] != 0) {
                                int idx = j;
                                while (idx != 0 && tmpGraph[idx - 1][i] == 0) {
                                    idx--;
                                }
                                if (idx != 0 && tmpGraph[idx - 1][i] == tmpGraph[j][i]) {
                                    if (!flag) {
                                        flag = true;
                                        tmpGraph[idx - 1][i] *= 2;
                                        tmpGraph[j][i] = 0;
                                    } else {
                                        flag = false;
                                        tmpGraph[idx][i] = tmpGraph[j][i];
                                        tmpGraph[j][i] = 0;
                                    }
                                } else if (idx != j) {
                                    flag = false;
                                    tmpGraph[idx][i] = tmpGraph[j][i];
                                    tmpGraph[j][i] = 0;
                                }

                            }
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < n; i++) {
                        flag = false;
                        for (int j = n - 1; j >= 0; j--) {
                            if (tmpGraph[j][i] != 0) {
                                int idx = j;
                                while (idx != n - 1 && tmpGraph[idx + 1][i] == 0) {
                                    idx++;
                                }
                                if (idx != n - 1 && tmpGraph[idx + 1][i] == tmpGraph[j][i]) {
                                    if (!flag) {
                                        flag = true;
                                        tmpGraph[idx + 1][i] *= 2;
                                        tmpGraph[j][i] = 0;
                                    } else {
                                        flag = false;
                                        tmpGraph[idx][i] = tmpGraph[j][i];
                                        tmpGraph[j][i] = 0;
                                    }
                                } else if (idx != j) {
                                    flag = false;
                                    tmpGraph[idx][i] = tmpGraph[j][i];
                                    tmpGraph[j][i] = 0;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < n; i++) {
                        flag = false;
                        for (int j = n - 1; j >= 0; j--) {
                            if (tmpGraph[i][j] != 0) {
                                int idx = j;
                                while (idx != n - 1 && tmpGraph[i][idx + 1] == 0) {
                                    idx++;
                                }
                                if (idx != n - 1 && tmpGraph[i][idx + 1] == tmpGraph[i][j]) {
                                    if (!flag) {
                                        flag = true;
                                        tmpGraph[i][idx + 1] *= 2;
                                        tmpGraph[i][j] = 0;
                                    } else {
                                        flag = false;
                                        tmpGraph[i][idx] = tmpGraph[i][j];
                                        tmpGraph[i][j] = 0;
                                    }
                                } else if (idx != j) {
                                    flag = false;
                                    tmpGraph[i][idx] = tmpGraph[i][j];
                                    tmpGraph[i][j] = 0;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < n; i++) {
                        flag = false;
                        for (int j = 0; j < n; j++) {
                            if (tmpGraph[i][j] != 0) {
                                int idx = j;
                                while (idx != 0 && tmpGraph[i][idx - 1] == 0) {
                                    idx--;
                                }
                                if (idx != 0 && tmpGraph[i][idx - 1] == tmpGraph[i][j]) {
                                    if (!flag) {
                                        flag = true;
                                        tmpGraph[i][idx - 1] *= 2;
                                        tmpGraph[i][j] = 0;
                                    } else {
                                        flag = false;
                                        tmpGraph[i][idx] = tmpGraph[i][j];
                                        tmpGraph[i][j] = 0;
                                    }
                                } else if (idx != j) {
                                    flag = false;
                                    tmpGraph[i][idx] = tmpGraph[i][j];
                                    tmpGraph[i][j] = 0;
                                }
                            }
                        }
                    }
                    break;
            }

        }
        for (int[] x : tmpGraph) {
            for (int y : x) {
                ans = Math.max(ans, y);
            }
        }


    }


}