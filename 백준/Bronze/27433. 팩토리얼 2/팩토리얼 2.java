import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        System.out.println(sup(n));
        
        
    }
    
    public static long sup(long n) {
        if (n <= 1) {
            return 1;
        }
        
        return n * sup(n - 1);
    }
}