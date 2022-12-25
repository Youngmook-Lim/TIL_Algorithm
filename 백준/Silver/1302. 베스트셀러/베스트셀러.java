import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        TreeMap<String, Integer> ts = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            ts.put(input, ts.getOrDefault(input, 0) + 1);
            max = Math.max(max, ts.get(input));
        }

        for (String s : ts.keySet()) {
            if (ts.get(s) == max) {
                System.out.println(s);
                break;
            }
        }


        br.close();
    }

}
