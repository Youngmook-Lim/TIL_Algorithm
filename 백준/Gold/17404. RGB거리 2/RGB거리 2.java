import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static int[][] top;
    static int[][] table;
    static int[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        table = new int[n][3];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
            table[i][2] = Integer.parseInt(st.nextToken());
        }

        getRGB();
        getRGBReverse();
        System.out.println(ans);

        br.close();
    }

    static void getRGB() {
        check = new int[2][3];
        top = new int[2][3];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                check[0][0] = table[0][0];
                check[0][1] = table[0][1];
                check[0][2] = table[0][2];
                top[0][0] = 0;
                top[0][1] = 1;
                top[0][2] = 2;
            } else if (i < n - 1) {
                if (check[0][1] < check[0][2]) {
                    check[1][0] = table[i][0] + check[0][1];
                    top[1][0] = top[0][1];
                } else {
                    check[1][0] = table[i][0] + check[0][2];
                    if (check[0][1] == check[0][2] && i == 1) {
                        top[1][0] = -1;
                    } else {
                        top[1][0] = top[0][2];
                    }
                }

                if (check[0][0] < check[0][2]) {
                    check[1][1] = table[i][1] + check[0][0];
                    top[1][1] = top[0][0];
                } else {
                    check[1][1] = table[i][1] + check[0][2];
                    if (check[0][0] == check[0][2] && i == 1) {
                        top[1][1] = -1;
                    } else {
                        top[1][1] = top[0][2];
                    }
                }

                if (check[0][0] < check[0][1]) {
                    check[1][2] = table[i][2] + check[0][0];
                    top[1][2] = top[0][0];
                } else {
                    check[1][2] = table[i][2] + check[0][1];
                    if (check[0][0] == check[0][1] && i == 1) {
                        top[1][2] = -1;
                    } else {
                        top[1][2] = top[0][1];
                    }
                }

                check[0][0] = check[1][0];
                check[0][1] = check[1][1];
                check[0][2] = check[1][2];
                top[0][0] = top[1][0];
                top[0][1] = top[1][1];
                top[0][2] = top[1][2];
            } else {
                if (top[0][1] == 0 && top[0][2] == 0) {
                    check[1][0] = Integer.MAX_VALUE;
                } else if (top[0][1] != 0 && top[0][2] != 0) {
                    check[1][0] = table[i][0] + Math.min(check[0][1], check[0][2]);
                } else {
                    if (top[0][1] != 0) {
                        check[1][0] = table[i][0] + check[0][1];
                    } else {
                        check[1][0] = table[i][0] + check[0][2];
                    }
                }

                if (top[0][0] == 1 && top[0][2] == 1) {
                    check[1][1] = Integer.MAX_VALUE;
                } else if (top[0][0] != 1 && top[0][2] != 1) {
                    check[1][1] = table[i][1] + Math.min(check[0][0], check[0][2]);
                } else {
                    if (top[0][0] != 1) {
                        check[1][1] = table[i][1] + check[0][0];
                    } else {
                        check[1][1] = table[i][1] + check[0][2];
                    }
                }

                if (top[0][0] == 2 && top[0][1] == 2) {
                    check[1][2] = Integer.MAX_VALUE;
                } else if (top[0][0] != 2 && top[0][1] != 2) {
                    check[1][2] = table[i][2] + Math.min(check[0][0], check[0][1]);
                } else {
                    if (top[0][0] != 2) {
                        check[1][2] = table[i][2] + check[0][0];
                    } else {
                        check[1][2] = table[i][2] + check[0][1];
                    }
                }

            }
//            for (int[] x : check) {
//                System.out.println(Arrays.toString(x));
//            }
//            for (int[] x : top) {
//                System.out.println(Arrays.toString(x));
//            }
//            System.out.println();

        }
        ans = Math.min(ans, Math.min(Math.min(check[1][0], check[1][1]), check[1][2]));
    }

    static void getRGBReverse() {
        check = new int[2][3];
        top = new int[2][3];

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                check[0][0] = table[n - 1][0];
                check[0][1] = table[n - 1][1];
                check[0][2] = table[n - 1][2];
                top[0][0] = 0;
                top[0][1] = 1;
                top[0][2] = 2;
            } else if (i > 0) {
                if (check[0][1] < check[0][2]) {
                    check[1][0] = table[i][0] + check[0][1];
                    top[1][0] = top[0][1];
                } else {
                    check[1][0] = table[i][0] + check[0][2];
                    if (check[0][1] == check[0][2] && i == n - 2) {
                        top[1][0] = -1;
                    } else {
                        top[1][0] = top[0][2];
                    }
                }

                if (check[0][0] < check[0][2]) {
                    check[1][1] = table[i][1] + check[0][0];
                    top[1][1] = top[0][0];
                } else {
                    check[1][1] = table[i][1] + check[0][2];
                    if (check[0][0] == check[0][2] && i == n - 2) {
                        top[1][1] = -1;
                    } else {
                        top[1][1] = top[0][2];
                    }
                }

                if (check[0][0] < check[0][1]) {
                    check[1][2] = table[i][2] + check[0][0];
                    top[1][2] = top[0][0];
                } else {
                    check[1][2] = table[i][2] + check[0][1];
                    if (check[0][0] == check[0][1] && i == n - 2) {
                        top[1][2] = -1;
                    } else {
                        top[1][2] = top[0][1];
                    }
                }

                check[0][0] = check[1][0];
                check[0][1] = check[1][1];
                check[0][2] = check[1][2];
                top[0][0] = top[1][0];
                top[0][1] = top[1][1];
                top[0][2] = top[1][2];
            } else {
                if (top[0][1] == 0 && top[0][2] == 0) {
                    check[1][0] = Integer.MAX_VALUE;
                } else if (top[0][1] != 0 && top[0][2] != 0) {
                    check[1][0] = table[i][0] + Math.min(check[0][1], check[0][2]);
                } else {
                    if (top[0][1] != 0) {
                        check[1][0] = table[i][0] + check[0][1];
                    } else {
                        check[1][0] = table[i][0] + check[0][2];
                    }
                }

                if (top[0][0] == 1 && top[0][2] == 1) {
                    check[1][1] = Integer.MAX_VALUE;
                } else if (top[0][0] != 1 && top[0][2] != 1) {
                    check[1][1] = table[i][1] + Math.min(check[0][0], check[0][2]);
                } else {
                    if (top[0][0] != 1) {
                        check[1][1] = table[i][1] + check[0][0];
                    } else {
                        check[1][1] = table[i][1] + check[0][2];
                    }
                }

                if (top[0][0] == 2 && top[0][1] == 2) {
                    check[1][2] = Integer.MAX_VALUE;
                } else if (top[0][0] != 2 && top[0][1] != 2) {
                    check[1][2] = table[i][2] + Math.min(check[0][0], check[0][1]);
                } else {
                    if (top[0][0] != 2) {
                        check[1][2] = table[i][2] + check[0][0];
                    } else {
                        check[1][2] = table[i][2] + check[0][1];
                    }
                }

            }
        }

        ans = Math.min(ans, Math.min(Math.min(check[1][0], check[1][1]), check[1][2]));
    }

}

