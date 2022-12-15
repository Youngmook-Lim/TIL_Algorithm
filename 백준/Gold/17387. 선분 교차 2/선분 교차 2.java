import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
 * 1. 각 선분의 slope A 구하고 같으면(평행하면) 0 (x값이 같은거 주의)
 * 2. y = Ax + B : B 각각 구하고 교차점 구하기 (x0 = (B2 - B1) / (A1 - A2))
 * 3. x0가 교차 구간 내에 있는지 확인
 * */
public class Main {

    static final double ERROR = 10000;
    static double x1, y1, x2, y2;
    static double x3, y3, x4, y4;
    static double A1, A2, B1, B2;
    static double x0, y0;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x1 = Double.parseDouble(st.nextToken());
        y1 = Double.parseDouble(st.nextToken());
        x2 = Double.parseDouble(st.nextToken());
        y2 = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x3 = Double.parseDouble(st.nextToken());
        y3 = Double.parseDouble(st.nextToken());
        x4 = Double.parseDouble(st.nextToken());
        y4 = Double.parseDouble(st.nextToken());

        getSlopes();

        if (A1 != Double.MAX_VALUE) {
            B1 = y1 - A1 * x1;
        }
        if (A2 != Double.MAX_VALUE) {
            B2 = y3 - A2 * x3;
        }
//        System.out.println("A : " + A1 + " " + A2);
//        System.out.println("B : " + B1 + " " + B2);

        if (A1 == A2) {
            if (B1 != B2) {
                ans = 0;
            } else {
                ans = check('0') ? 1 : 0;
            }
            System.out.println(ans);
            return;
        }

        if (A1 == Double.MAX_VALUE) {
            y0 = A2 * x1 + B2;
            x0 = x1;
        } else if (A2 == Double.MAX_VALUE) {
            y0 = A1 * x3 + B1;
            x0 = x3;
        } else {
            x0 = (B2 - B1) / (A1 - A2);
            y0 = A1 * x0 + B1;
        }

        x0 = (double) Math.round(x0 * ERROR) / ERROR;
        y0 = (double) Math.round(y0 * ERROR) / ERROR;

        ans = check('1') ? 1 : 0;
        System.out.println(ans);

        br.close();
    }

    static boolean check(char axis) {
        if (axis == '1') {
            return !(y0 < Math.max(Math.min(y1, y2), Math.min(y3, y4))
                    || y0 > Math.min(Math.max(y1, y2), Math.max(y3, y4))
                    || x0 < Math.max(Math.min(x1, x2), Math.min(x3, x4))
                    || x0 > Math.min(Math.max(x1, x2), Math.max(x3, x4)));
        } else {
            return Math.max(Math.min(x1, x2), Math.min(x3, x4))
                    <= Math.min(Math.max(x1, x2), Math.max(x3, x4)) &&
                    Math.max(Math.min(y1, y2), Math.min(y3, y4))
                            <= Math.min(Math.max(y1, y2), Math.max(y3, y4));
        }
    }

    static void getSlopes() {
        if (x1 != x2) {
            A1 = (y2 - y1) / (x2 - x1);
        } else {
            A1 = Double.MAX_VALUE;
        }

        if (x3 != x4) {
            A2 = (y4 - y3) / (x4 - x3);
        } else {
            A2 = Double.MAX_VALUE;
        }
    }
    

}
