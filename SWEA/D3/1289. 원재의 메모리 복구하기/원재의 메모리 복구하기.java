
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = 10;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String memory = br.readLine();
            String zeros = "";
            int len = memory.length();
            for (int i = 0; i < len; i++) {
                zeros += "0";
            }

            int cnt = 0;

            while (!memory.equals(zeros)) {
                for (int i = 0; i < len; i++) {
                    if (memory.charAt(i) != zeros.charAt(i)) {
                        StringBuilder zerosString = new StringBuilder(zeros);
                        for (int j = i; j < len; j++) {
                            zerosString.setCharAt(j, memory.charAt(i));
                        }
                        zeros = zerosString.toString();
                        break;
                    }
                }
                cnt++;
            }

            System.out.println("#" + t + " " + cnt);

        }


        br.close();
    }

}