import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
 * 1. 각 선분의 slope A 구하고 같으면(평행하면) 0 (x값이 같은거 주의)
 * 2. y = Ax + B : B 각각 구하고 교차점 구하기 (x0 = (B2 - B1) / (A1 - A2))
 * 3. x0가 교차 구간 내에 있는지 확인
 * */
public class Main {

    static long x1, y1, x2, y2;
    static long x3, y3, x4, y4;
    static int p123, p124, p341, p342, res1, res2, ans;

    static class P {
        long x, y;

        public P(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static P[] p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x1 = Long.parseLong(st.nextToken());
        y1 = Long.parseLong(st.nextToken());
        x2 = Long.parseLong(st.nextToken());
        y2 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x3 = Long.parseLong(st.nextToken());
        y3 = Long.parseLong(st.nextToken());
        x4 = Long.parseLong(st.nextToken());
        y4 = Long.parseLong(st.nextToken());
        ans = 0;

        p = new P[4];
        p[0] = new P(x1, y1);
        p[1] = new P(x2, y2);
        p[2] = new P(x3, y3);
        p[3] = new P(x4, y4);

        p123 = ccw(p[0], p[1], p[2]);
        p124 = ccw(p[0], p[1], p[3]);
        p341 = ccw(p[2], p[3], p[0]);
        p342 = ccw(p[2], p[3], p[1]);

        res1 = p123 * p124;
        res2 = p341 * p342;

        if (res1 == 0 && res2 == 0) {
            boolean resultX = Math.max(Math.min(p[0].x, p[1].x), Math.min(p[2].x, p[3].x))
                    <= Math.min(Math.max(p[0].x, p[1].x), Math.max(p[2].x, p[3].x));
            boolean resultY = Math.max(Math.min(p[0].y, p[1].y), Math.min(p[2].y, p[3].y))
                    <= Math.min(Math.max(p[0].y, p[1].y), Math.max(p[2].y, p[3].y));
            if (resultX && resultY) {
                ans = 1;
            }
        } else if (res1 <= 0 && res2 <= 0) {
            ans = 1;
        }

        System.out.println(ans);

        br.close();
    }

    static int ccw(P a, P b, P c) {
        long res = (a.x * b.y + b.x * c.y + c.x * a.y) - (b.x * a.y + c.x * b.y + a.x * c.y);
        return (res > 0) ? 1 : (res == 0) ? 0 : -1;
    }

}
