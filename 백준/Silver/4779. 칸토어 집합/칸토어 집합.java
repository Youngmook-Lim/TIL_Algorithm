import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, size;
    static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        try {
            while (true) {
                n = Integer.parseInt(br.readLine());
                size = (int) Math.pow(3, n);

                arr = new char[size];
                for (int i = 0; i < size; i++) {
                    arr[i] = '-';
                }

                recur(0, size);
                
                for (char x : arr) {
                    sb.append(x);
                }

                sb.append('\n');
            }

        } catch (Exception e) {
            System.out.println(sb);
        }

        br.close();

    }

    static void recur(int start, int end) {
        int len = end - start;

        if (len == 1) return;

        int left = start + len / 3;
        int right = end - len / 3;

        for (int i = left; i < right; i++) {
            arr[i] = ' ';
        }

        recur(start, left);
        recur(right, end);
    }


}