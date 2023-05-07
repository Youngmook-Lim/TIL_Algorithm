import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}
