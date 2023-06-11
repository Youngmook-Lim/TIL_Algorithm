import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        Map<Integer, String> map = new HashMap<>();
        map.put(s, "Soongsil");
        map.put(k, "Korea");
        map.put(h, "Hanyang");

        int sum = s + k + h;

        if (sum >= 100) {
            System.out.println("OK");
        } else {
            System.out.println(map.get(Math.min(s, Math.min(k, h))));
        }

        br.close();
    }
    

}
