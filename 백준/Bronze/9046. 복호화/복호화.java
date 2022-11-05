import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int[] arr = new int[26];
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                char x = str.charAt(i);
                if (x >= 'a' && x <= 'z') {
                    arr[x - 'a']++;
                }
            }
            int max = 0;
            int maxIdx = 0;
            int cnt = 0;

            for (int i = 0; i < 26; i++) {
                if (arr[i] >= max) {
                    if (arr[i] == max) {
                        cnt++;
                    } else {
                        cnt = 1;
                        max = arr[i];
                        maxIdx = i;
                    }
                }
            }

            if (cnt > 1) {
                sb.append('?').append('\n');
            } else {
                sb.append((char) (maxIdx + 'a')).append('\n');
            }
        }

        System.out.println(sb);
        br.close();
    }


}

