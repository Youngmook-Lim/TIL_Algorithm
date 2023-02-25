import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();

            if (cmd.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (String x : list) {
            sb.append(x).append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}


