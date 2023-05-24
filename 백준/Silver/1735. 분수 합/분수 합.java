import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int aUp, aDown, bUp, bDown;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        aUp = Integer.parseInt(st.nextToken());
        aDown = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        bUp = Integer.parseInt(st.nextToken());
        bDown = Integer.parseInt(st.nextToken());

        int newDown = aDown * bDown;
        int newUp = aUp * bDown + bUp * aDown;

        int gcd = getGcd(newUp, newDown);

        System.out.println(newUp / gcd + " " + newDown / gcd);
        
        br.close();
    }

    static int getGcd(int a, int b) {
        if (b != 0) {
            return getGcd(b, a % b);
        }
        return a;
    }

}
