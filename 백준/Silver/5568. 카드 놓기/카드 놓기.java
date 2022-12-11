import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n, m;
    static int[] arr, check;
    static boolean[] visited;
    static Set<String> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        check = new int[m];
        visited = new boolean[n];
        set = new HashSet<>();

        solution(0);

        System.out.println(set.size());

        br.close();
    }

    static void solution(int depth) {
        if (depth == m) {
            addToSet();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                check[depth] = arr[i];
                solution(depth + 1);
                visited[i] = false;
            }
        }
    }

    static void addToSet() {
        StringBuilder sb = new StringBuilder();
        for (int x : check) {
            sb.append(Integer.toString(x));
        }
        set.add(sb.toString());
    }

}
