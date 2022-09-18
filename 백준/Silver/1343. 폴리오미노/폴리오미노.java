import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] board = br.readLine().toCharArray();
        boolean flag = true;
        int startIdx = 0;
        int endIdx;

        for (int i = 0; i <= board.length; i++) {
            if (i == board.length || board[i] == '.') {
                endIdx = i;
                int substrLength = endIdx - startIdx;
                if (substrLength % 2 == 1) {
                    flag = false;
                    break;
                } else {
                    int numOfA = (substrLength / 4) * 4;
                    for (int j = startIdx; j < endIdx; j++) {
                        if (numOfA-- > 0) {
                            board[j] = 'A';
                        } else {
                            board[j] = 'B';
                        }
                    }
                    startIdx = i + 1;
                }
            }
        }

        if (flag) {
            for (char x : board) {
                bw.write(x);
            }
            bw.write("\n");
        } else {
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}