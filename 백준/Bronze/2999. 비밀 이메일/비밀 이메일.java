import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String encrypted = br.readLine();
        int n = encrypted.length();
        int r = 0;
        int c = 0;
        char[][] arr;

        for (int i = (int) Math.floor(Math.sqrt(n)); i > 0; i--) {
            if (n % i == 0) {
                r = i;
                c = n / i;
                break;
            }
        }

        arr = new char[r][c];
        int idx = 0;

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                arr[j][i] = encrypted.charAt(idx);
                idx++;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                bw.write(arr[i][j]);
            }
        }
        bw.write("\n");


        bw.flush();
        bw.close();
        br.close();

    }

}

