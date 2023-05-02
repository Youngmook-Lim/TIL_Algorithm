import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<String> set = new HashSet<>();
        set.add("ChongChong");

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String one = st.nextToken();
            String two = st.nextToken();

            if (set.contains(one) || set.contains(two)) {
                set.add(one);
                set.add(two);
            }
        }

        System.out.println(set.size());

        br.close();
    }


}
