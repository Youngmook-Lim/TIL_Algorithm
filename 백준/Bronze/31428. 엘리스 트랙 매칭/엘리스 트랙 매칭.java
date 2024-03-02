import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Character c = st.nextToken().charAt(0);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Character me = br.readLine().charAt(0);

        System.out.println(map.get(me) == null ? 0 : map.get(me));

        br.close();
    }


}

