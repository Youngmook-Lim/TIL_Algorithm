import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String word = br.readLine();
            String newWord = "";

            for (int i = 0; i < word.length(); i++) {
                char x = word.charAt(i);
                if (!(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u')) {
                    newWord += x;
                }
            }


            System.out.println("#" + t + " " + newWord);

        }

        br.close();
    }
}