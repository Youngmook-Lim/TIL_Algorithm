import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static List<Integer> arr;
    static int m;
    static List<Integer> cmds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
        int T = 10;
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while (m > 0) {
                String cmd = st.nextToken();
                if (cmd.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < y; i++) {
                        arr.add(x, Integer.parseInt(st.nextToken()));
                        x++;
                    }
                } else if (cmd.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < y; i++) {
                        arr.remove(x + 1);
                    }
                } else {
                    int y = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < y; i++) {
                        arr.add(Integer.parseInt(st.nextToken()));
                    }
                }
                m--;
            }

            System.out.print("#" + t + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();

        }
        br.close();
    }
}