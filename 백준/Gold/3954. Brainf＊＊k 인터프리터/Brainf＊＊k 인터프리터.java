import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static final int LIMIT = 50000000;
    static Stack<Integer> stack;
    static int[] memory, brackets;
    static int sm, sc, si, idx, pointer, inputIdx, cnt;

    static String code, input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            sm = Integer.parseInt(st.nextToken());
            sc = Integer.parseInt(st.nextToken());
            si = Integer.parseInt(st.nextToken());
            code = br.readLine();
            input = br.readLine();
            stack = new Stack<>();
            memory = new int[sm];
            brackets = new int[sc];

            for (int i = 0; i < sc; i++) {
                char cur = code.charAt(i);
                if (cur == '[') {
                    stack.push(i);
                } else if (cur == ']') {
                    int startBracket = stack.pop();
                    brackets[startBracket] = i;
                    brackets[i] = startBracket;
                }
            }

            idx = 0;
            pointer = 0;
            inputIdx = 0;
            cnt = 0;

            while (idx < sc && cnt++ <= LIMIT) {
                runProgram();
            }

            if (idx == sc) {
                sb.append("Terminates\n");
            } else {
                int maxLoopIdx, minLoopIdx;
                maxLoopIdx = minLoopIdx = idx;
                while (cnt-- > 0) {
                    runProgram();
                    minLoopIdx = Math.min(minLoopIdx, idx);
                    maxLoopIdx = Math.max(maxLoopIdx, idx);
                }

                sb.append("Loops " + (minLoopIdx - 1) + " " + maxLoopIdx + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void runProgram() {
        char cmd = code.charAt(idx);

        switch (cmd) {
            case '+':
                memory[pointer] = (memory[pointer] == 255) ? 0 : memory[pointer] + 1;
                break;
            case '-':
                memory[pointer] = (memory[pointer] == 0) ? 255 : memory[pointer] - 1;
                break;
            case '<':
                pointer = (pointer == 0) ? sm - 1 : pointer - 1;
                break;
            case '>':
                pointer = (pointer == sm - 1) ? 0 : pointer + 1;
                break;
            case '.':
                break;
            case ',':
                if (inputIdx == si) {
                    memory[pointer] = 255;
                } else {
                    memory[pointer] = input.charAt(inputIdx++);
                }
                break;
            case '[':
                if (memory[pointer] == 0) {
                    idx = brackets[idx];
                }
                break;
            case ']':
                if (memory[pointer] != 0) {
                    idx = brackets[idx];
                }
                break;
        }
        idx++;
    }

}

