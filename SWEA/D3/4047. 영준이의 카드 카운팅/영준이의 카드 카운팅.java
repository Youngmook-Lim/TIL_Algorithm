import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String cards = br.readLine();
            boolean flag = true;

            Set<Integer> spades = new HashSet<>(Arrays.asList(numbers));
            Set<Integer> diamonds = new HashSet<>(Arrays.asList(numbers));
            Set<Integer> hearts = new HashSet<>(Arrays.asList(numbers));
            Set<Integer> clovers = new HashSet<>(Arrays.asList(numbers));

            for (int i = 0; i < cards.length(); i += 3) {
                if (!flag) break;

                char suit = cards.charAt(i);
                int num = Integer.parseInt((i == cards.length() - 3) ? cards.substring(i + 1) : cards.substring(i + 1, i + 3));

                Set<Integer> curSet;
                switch (suit) {
                    case ('S'):
                        curSet = spades;
                        break;
                    case ('D'):
                        curSet = diamonds;
                        break;
                    case ('H'):
                        curSet = hearts;
                        break;
                    case ('C'):
                        curSet = clovers;
                        break;
                    default:
                        curSet = new HashSet<>();
                }

                if (curSet.contains(num)) {
                    curSet.remove(num);
                } else {
                    bw.write("#" + t + " ERROR" + "\n");
                    flag = false;
                    break;
                }
            }

            if (flag) {
                bw.write("#" + t + " " + spades.size() + " " + diamonds.size() + " " +
                        hearts.size() + " " + clovers.size() + "\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}