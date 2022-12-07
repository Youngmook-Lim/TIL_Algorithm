import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder and = new StringBuilder();
        StringBuilder or = new StringBuilder();
        StringBuilder xor = new StringBuilder();
        StringBuilder notA = new StringBuilder();
        StringBuilder notB = new StringBuilder();


        String A = br.readLine();
        String B = br.readLine();

        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);

            and.append((a == '1' && b == '1') ? '1' : '0');
            or.append((a == '0' && b == '0') ? '0' : '1');
            xor.append((a == b) ? '0' : '1');
            notA.append(a == '1' ? '0' : '1');
            notB.append(b == '1' ? '0' : '1');
        }

        System.out.println(and);
        System.out.println(or);
        System.out.println(xor);
        System.out.println(notA);
        System.out.println(notB);
        
        br.close();
    }


}
