import java.io.*;

public class Main {

    static int[] mushrooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        mushrooms = new int[10];
        for (int i = 0; i < 10; i++) {
            mushrooms[i] = Integer.parseInt(br.readLine());
        }

        int min = Integer.MAX_VALUE;
        int total = 0;
        boolean flag = false;

        for (int i = 0; i < 10; i++) {
            total += mushrooms[i];
            int diff = Math.abs(100 - total);
            if (min < diff) {
                bw.write(total - mushrooms[i] + "\n");
                flag = true;
                break;
            } else {
                min = diff;
            }
        }
        if (!flag) {
            bw.write(total + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}

