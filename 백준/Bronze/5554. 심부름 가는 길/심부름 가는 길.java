import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int totalSec = 0;

        for (int i = 0; i < 4; i++) {
            totalSec += Integer.parseInt(br.readLine());
        }

        int totalMin = totalSec / 60;
        int remainingSec = totalSec - totalMin * 60;

        System.out.println(totalMin);
        System.out.println(remainingSec);

        br.close();
    }


}
