import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int sum = a + b + c;

        if (a == 60 && b == 60 & c == 60) {
            System.out.println("Equilateral");
        } else if (sum == 180 && (a == b || b == c || c == a)) {
            System.out.println("Isosceles");
        } else if (sum == 180) {
            System.out.println("Scalene");
        } else {
            System.out.println("Error");
        }

        br.close();
    }


}














