import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static int l, c;
    static char[] arr;
    static List<Character> list;
    static Set<Character> vowels;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        list = new ArrayList<>();
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb);

        br.close();
    }

    static void dfs(int idx, int depth) {
        if (depth == l) {
            check();
            return;
        }

        for (int i = idx; i < c; i++) {
            list.add(arr[i]);
            dfs(i + 1, depth + 1);
            list.remove(list.size() - 1);
        }
    }

    static void check() {
        int cntVowels = 0;
        int cntConsonants = 0;
        for (char x : list) {
            if (vowels.contains(x)) {
                cntVowels++;
            } else {
                cntConsonants++;
            }
        }
        if (cntVowels >= 1 && cntConsonants >= 2) {
            for (char x : list) {
                sb.append(x);
            }
            sb.append('\n');
        }
    }


}
