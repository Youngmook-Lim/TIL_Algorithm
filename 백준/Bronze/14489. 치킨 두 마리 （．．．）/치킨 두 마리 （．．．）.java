import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int chicken = Integer.parseInt(br.readLine()) * 2;
        int sum = a + b;
        if (sum >= chicken) {
            System.out.println(sum - chicken);
        } else {
            System.out.println(sum);
        }

        br.close();
    }


}


