import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static int[] arr;
    static boolean[] visited;
    static boolean flag;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            flag = false;
            dfs(i, i);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for (int x : list) {
            sb.append(x).append('\n');
        }

        System.out.println(sb);
        
        br.close();
    }

    static void dfs(int start, int cur) {
        
        visited[cur] = true;

        if (!visited[arr[cur]] || arr[cur] == start) {
            if (arr[cur] == start) {
                flag = true;
            } else {
                dfs(start, arr[cur]);
            }
        }

        if (flag) {
            list.add(cur);
        } else {
            visited[cur] = false;
        }
    }

}














