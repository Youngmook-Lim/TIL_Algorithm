import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i : set) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);

        br.close();
    }


}



