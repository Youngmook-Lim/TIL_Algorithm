import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int total = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());
            if (!map.containsKey(cow)) {
                map.put(cow, road);
            } else {
                if (map.get(cow) != road) {
                    total++;
                    map.put(cow, road);
                }
            }
        }
        System.out.println(total);

        br.close();
    }


}

