import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        String word = br.readLine();
        int strLen = str.length();
        int wordLen = word.length();
        int max = 0;

        for (int i = 0; i <= strLen - wordLen; i++) {
            int cnt = 0;
            for (int j = i; j <= strLen - wordLen; j++) {
                boolean flag = true;
                for (int k = 0; k < wordLen; k++) {
                    if (str.charAt(j) == word.charAt(k)) {
                        j++;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    cnt++;
                    j--;
                }
            }
            if (cnt >= max) {
                max = cnt;
            } else {
                break;
            }
        }

        System.out.println(max);

        br.close();
    }


}
