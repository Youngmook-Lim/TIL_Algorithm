import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] sentence = br.readLine().split(" ");
            sb = new StringBuilder();

            for (int i = 0; i < sentence.length; i++) {
                for (int j = sentence[i].length() - 1; j >= 0; j--) {
                    sb.append(sentence[i].charAt(j));
                }
                sb.append(' ');
            }

            bw.write(sb.toString() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}