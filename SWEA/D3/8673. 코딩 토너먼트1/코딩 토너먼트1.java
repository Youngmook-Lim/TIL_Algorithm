import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int k;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            k = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < Math.pow(2, k); i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int total = 0;

            while (list.size() > 1) {
                Integer[] tmp = new Integer[list.size() / 2];
                int idx = 0;
                for (int i = 0; i < list.size() - 1; i += 2) {
                    if (list.get(i) >= list.get(i + 1)) {
                        tmp[idx++] = list.get(i);
                        total += list.get(i) - list.get(i + 1);
                    } else {
                        tmp[idx++] = list.get(i + 1);
                        total += list.get(i + 1) - list.get(i);
                    }
                }
                list.clear();
                list.addAll(Arrays.asList(tmp));
            }

            System.out.println("#" + t + " " + total);

        }
        br.close();
    }
}