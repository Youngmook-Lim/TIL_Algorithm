import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] ans = triangle(n);

        for (String x : ans) {
            sb.append(x).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    static String[] triangle(int num) {
        if (num == 3) {
            String[] base = new String[num];
            base[0] = "  *  ";
            base[1] = " * * ";
            base[2] = "*****";
            return base;
        }

        String[] prev = triangle(num / 2);
        String[] cur = new String[num];
        for (int i = 0; i < num / 2; i++) {
            cur[i] = repeatChar(num / 2) + prev[i] + repeatChar(num / 2);
        }
        for (int i = num / 2; i < num; i++) {
            cur[i] = prev[i - num / 2] + " " + prev[i - num / 2];
        }

        return cur;
    }

    static String repeatChar(int times) {
        return new String(new char[times]).replace("\0", " ");
    }


}

