import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String word = br.readLine();

        String max = getMax(word);
        String min = getMin(word);

        System.out.println(max);
        System.out.println(min);

        br.close();
    }

    static String getMin(String word) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'M') {
                cnt++;
            } else {
                if (cnt > 0) {
                    sb.append(1);
                    for (int j = 0; j < cnt - 1; j++) {
                        sb.append(0);
                    }
                }
                sb.append(5);
                cnt = 0;
            }
        }
        if (cnt > 0) {
            sb.append(1);
            for (int j = 0; j < cnt - 1; j++) {
                sb.append(0);
            }
        }
        return sb.toString();
    }

    static String getMax(String word) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'M') {
                cnt++;
            } else {
                sb.append(5);
                for (int j = 0; j < cnt; j++) {
                    sb.append(0);
                }
                cnt = 0;
            }
        }
        for (int i = 0; i < cnt; i++) {
            sb.append(1);
        }
        return sb.toString();
    }


}



