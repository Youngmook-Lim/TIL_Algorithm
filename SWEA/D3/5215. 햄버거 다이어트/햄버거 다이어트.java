import java.io.*;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int n;
    static int l;
    static boolean[] check;
    static int[][] ingredients;
    static int maxPoints;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            check = new boolean[n];
            ingredients = new int[n][2];
            maxPoints = 0;
 
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                ingredients[i][0] = Integer.parseInt(st.nextToken());
                ingredients[i][1] = Integer.parseInt(st.nextToken());
            }
 
            hamburger(0);
 
            bw.write("#" + t + " " + maxPoints + "\n");
        }
 
        bw.flush();
        bw.close();
        br.close();
    }
 
    static void hamburger(int idx) {
        if (idx == n) {
            int totalPoints = 0;
            int totalCalories = 0;
            for (int i = 0; i < n; i++) {
                if (check[i]) {
                    totalPoints += ingredients[i][0];
                    totalCalories += ingredients[i][1];
                }
            }
            if (totalCalories <= l) {
                maxPoints = Integer.max(maxPoints, totalPoints);
            }
            return;
        }
 
        check[idx] = true;
        hamburger(idx + 1);
        check[idx] = false;
        hamburger(idx + 1);
    }
}