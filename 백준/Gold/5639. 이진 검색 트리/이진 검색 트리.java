import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> list = new ArrayList<>();

    public static void dfs(int start, int end) {
        if (start > end) return;

        int mid = end + 1;
        for (int i = start + 1; i < end + 1; i++) {
            if (list.get(i) > list.get(start)) {
                mid = i;
                break;
            }
        }

        dfs(start + 1, mid - 1);
        dfs(mid, end);
        System.out.println(list.get(start));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                list.add(Integer.parseInt(br.readLine()));
            } catch (Exception e) {
                break;
            }
        }

        dfs(0, list.size() - 1);

        br.close();
    }
}
