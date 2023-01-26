import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String word;
    static Set<Character> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        StringBuilder sb = new StringBuilder();

        while (true) {
            word = br.readLine();
            if (word.equals("end")) break;

            boolean vowelCheck = false;
            int vowelCnt = 0;
            int consonantCnt = 0;
            char prev = '0';

            boolean isAcceptable = true;

            for (int i = 0; i < word.length(); i++) {
                if (isVowel(word.charAt(i))) {
                    consonantCnt = 0;
                    vowelCnt++;
                    vowelCheck = true;
                } else {
                    vowelCnt = 0;
                    consonantCnt++;
                }

                if (vowelCnt == 3 || consonantCnt == 3) {
                    isAcceptable = false;
                    break;
                }

                if (i != 0) {
                    if (prev == word.charAt(i)) {
                        if (prev != 'o' && prev != 'e') {
                            isAcceptable = false;
                            break;
                        }
                    }
                }
                prev = word.charAt(i);
            }

            if (isAcceptable && vowelCheck) {
                sb.append(String.format("<%s> is acceptable.", word)).append('\n');
            } else {
                sb.append(String.format("<%s> is not acceptable.", word)).append('\n');
            }

        }

        System.out.println(sb);

        br.close();
    }

    static boolean isVowel(char c) {
        if (set.contains(c)) {
            return true;
        }
        return false;
    }


}
