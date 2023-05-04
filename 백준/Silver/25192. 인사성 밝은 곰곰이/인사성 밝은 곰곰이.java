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

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            if (a.equals("ENTER")) {
                set.clear();
            } else {
                if (!set.contains(a)) {
                    cnt++;
                    set.add(a);
                }
            }

        }

        System.out.println(cnt);

        br.close();
    }


}
