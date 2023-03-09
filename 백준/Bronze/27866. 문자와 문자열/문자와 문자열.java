import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String string = br.readLine();

        System.out.println(string.charAt(Integer.parseInt(br.readLine()) - 1));

        br.close();
    }


}


