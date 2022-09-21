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

        @Override
        public String toString() {
            return "Ingredient{" +
                    "sour=" + sour +
                    ", bitter=" + bitter +
                    '}';
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

    static void dfs(int depth, int visited) {
        if (depth == n) {
            if (visited != 0) {
                ans = Math.min(ans, getDiff(visited));
            }

            return;
        }

        dfs(depth + 1, visited | (1 << depth));
        dfs(depth + 1, visited);

    }

    static int getDiff(int visited) {
        int sourTotal = 1;
        int bitterTotal = 0;
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) != 0) {
                Ingredient ig = arr[i];
                sourTotal *= ig.sour;
                bitterTotal += ig.bitter;
            }
        }
        return Math.abs(sourTotal - bitterTotal);
    }

}