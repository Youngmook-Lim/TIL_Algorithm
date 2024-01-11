import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] input = br.readLine().split("/");
        System.out.println(Integer.parseInt(input[1]) == 0 || (Integer.parseInt(input[0]) + Integer.parseInt(input[2])) < Integer.parseInt(input[1]) ? "hasu" : "gosu");

        br.close();
    }


}

