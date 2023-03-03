import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int maxCnt = 0;
        long selected = Long.MAX_VALUE;

        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long number = Long.parseLong(br.readLine());
            map.put(number, map.getOrDefault(number, 0) + 1);
            if (map.get(number) >= maxCnt) {
                if (map.get(number) == maxCnt) {
                    selected = Math.min(selected, number);
                } else {
                    maxCnt = map.get(number);
                    selected = number;
                }
            }
        }

        System.out.println(selected);


        br.close();
    }

}


