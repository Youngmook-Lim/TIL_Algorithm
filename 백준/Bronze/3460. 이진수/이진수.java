import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String bin = Integer.toBinaryString(Integer.parseInt(br.readLine()));
            for (int j = 0; j < bin.length(); j++) {
                if (bin.charAt(bin.length() - 1 - j) == '1') {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }

        br.close();
    }


}

