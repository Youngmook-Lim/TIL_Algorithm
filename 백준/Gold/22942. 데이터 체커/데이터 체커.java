import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static Stack<Circle> stack;
    static Circle[] arr;

    static class Circle implements Comparable<Circle> {
        int x, r, min, max;

        public Circle(int x, int r, int min, int max) {
            this.x = x;
            this.r = r;
            this.min = min;
            this.max = max;
        }

        @Override
        public int compareTo(Circle o) {
            return this.min - o.min;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new Circle[n];
        stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            arr[i] = new Circle(x, r, x - r, x + r);
        }

        Arrays.sort(arr);


        for (int i = 0; i < n; i++) {
            Circle cur = arr[i];

            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }

            while (!stack.isEmpty()) {
                Circle prev = stack.peek();
                if (isIntersect(cur, prev)) {
                    System.out.println("NO");
                    return;
                }
                if (prev.max < cur.min) {
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(cur);
        }

        System.out.println("YES");

        br.close();
    }

    static boolean isIntersect(Circle a, Circle b) {
        int d = Math.abs(a.x - b.x);
        if (Math.abs(a.r - b.r) < d && d < a.r + b.r) return true;
        if (d == a.r + b.r || d == Math.abs(a.r - b.r)) return true;
        return false;
    }

}
