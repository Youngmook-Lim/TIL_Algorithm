import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sumA = 0;
        int sumB = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            sumA += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            sumB += Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(sumA, sumB));

        br.close();
    }


}
