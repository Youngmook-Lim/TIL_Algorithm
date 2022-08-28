import java.io.*;
import java.util.*;

public class Main {

    static int n, ans;
    static int[] lineup;
    static int[][] arr;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        lineup = new int[9];
        lineup[3] = 1;

        arr = new int[n][9];
        ans = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(2);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void play() {
        int score = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            boolean[] field = new boolean[3];
            int out = 0;
            while (out != 3) {
                int curAct = arr[i][lineup[idx] - 1];
                switch (curAct) {
                    case 0:
                        out++;
                        break;
                    case 1:
                        for (int j = 2; j >= 0; j--) {
                            if (field[j]) {
                                if (j == 2) {
                                    score++;
                                    field[j] = false;
                                } else {
                                    field[j] = false;
                                    field[j + 1] = true;
                                }
                            }
                        }
                        field[0] = true;
                        break;
                    case 2:
                        for (int j = 2; j >= 0; j--) {
                            if (field[j]) {
                                if (j > 0) {
                                    score++;
                                    field[j] = false;
                                } else {
                                    field[j] = false;
                                    field[j + 2] = true;
                                }
                            }
                        }
                        field[1] = true;
                        break;
                    case 3:
                        for (int j = 2; j >= 0; j--) {
                            if (field[j]) {
                                score++;
                                field[j] = false;
                            }
                        }
                        field[2] = true;
                        break;
                    case 4:
                        for (int j = 2; j >= 0; j--) {
                            if (field[j]) {
                                score++;
                                field[j] = false;
                            }
                        }
                        score++;
                        break;
                }
                idx = (idx + 1) % 9;
            }
        }

        ans = Math.max(ans, score);
    }

    static void dfs(int depth) {
        if (depth == 10) {
            play();
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (lineup[i] != 0) continue;
            lineup[i] = depth;
            dfs(depth + 1);
            lineup[i] = 0;
        }
    }

}