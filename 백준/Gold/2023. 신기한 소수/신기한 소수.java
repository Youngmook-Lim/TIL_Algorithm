import java.io.*;

public class Main {

    static int n;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        dfs(0);

        bw.write(ans.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth) {
        if (depth == n) {
            ans.append(sb).append("\n");
            return;
        }

        for (int i = 0; i < 10; i++) {
            sb.append(i);
            if (isPrime(Integer.parseInt(sb.toString()))) {
                dfs(depth + 1);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        if (num == 2 || num == 3) return true;
        for (int i = 2; i < Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}