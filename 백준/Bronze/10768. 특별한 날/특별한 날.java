import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());

        if (month == 2 && day == 18) {
            System.out.println("Special");
        } else if (month < 2 || month == 2 && day < 18) {
            System.out.println("Before");
        } else {
            System.out.println("After");
        }

        br.close();
    }


}
