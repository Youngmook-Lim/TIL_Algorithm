import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int start = 2;
        for (int i = 0; i < n; i++) {
            start += Math.pow(2, i);
        }

        System.out.println((int) Math.pow(start, 2));

        br.close();
    }

}
