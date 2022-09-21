import java.io.*;
import java.util.*;

public class Main {

    static int n, ans;
    static Ingredient[] arr;
    static List<Integer> list;

    static class Ingredient {
        int sour, bitter;

        Ingredient(int sour, int bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new Ingredient[n];
        list = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int idx) {
        if (depth == n) {
            if (!list.isEmpty()) {
                ans = Math.min(ans, getDiff());
            }
            return;
        }

        for (int i = idx; i < n; i++) {
            list.add(i);
            dfs(depth + 1, i + 1);
            list.remove(list.size() - 1);
            dfs(depth + 1, i + 1);
        }
    }

    static int getDiff() {
        int sourTotal = 1;
        int bitterTotal = 0;
        for (int x : list) {
            Ingredient ig = arr[x];
            sourTotal *= ig.sour;
            bitterTotal += ig.bitter;
        }
        return Math.abs(sourTotal - bitterTotal);
    }

}