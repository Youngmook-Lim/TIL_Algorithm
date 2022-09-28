import java.io.*;
import java.util.*;

public class Main {

    static int n, maxBrackets, ans;
    static String input;
    static List<Integer> nums, list;
    static List<String> ops;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        input = br.readLine();
        nums = new ArrayList<>();
        ops = new ArrayList<>();
        list = new ArrayList<>();
        ans = Integer.MIN_VALUE;
        for (int i = 0; i < input.length(); i++) {
            String tmp = input.substring(i, i + 1);
            if (tmp.matches("[+*-]")) {
                ops.add(tmp);
            } else {
                nums.add(Integer.parseInt(tmp));
            }
        }

        maxBrackets = nums.size() / 2;

        while (maxBrackets >= 0) {
            dfs(0);

            maxBrackets--;
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void calculate() {
        List<Integer> numsTmp = new ArrayList<>();
        List<String> opsTmp = new ArrayList<>();

        for (int i = 0; i < ops.size(); i++) {
            if (list.contains(i)) {
                int a = nums.get(i);
                int b = nums.get(i + 1);
                int result = 0;
                switch (ops.get(i)) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                }
                numsTmp.add(result);
                if (i != ops.size() - 1) {
                    opsTmp.add(ops.get(i + 1));
                    i++;
                }
            } else {
                numsTmp.add(nums.get(i));
                opsTmp.add(ops.get(i));
            }
        }
        if (!list.contains(ops.size() - 1)) {
            numsTmp.add(nums.get(nums.size() - 1));
        }

        int total = numsTmp.get(0);
        for (int i = 0; i < opsTmp.size(); i++) {
            switch (opsTmp.get(i)) {
                case "+":
                    total = total + numsTmp.get(i + 1);
                    break;
                case "-":
                    total = total - numsTmp.get(i + 1);
                    break;
                case "*":
                    total = total * numsTmp.get(i + 1);
                    break;
            }
        }
        ans = Math.max(ans, total);
    }

    static void dfs(int idx) {
        if (list.size() == maxBrackets) {
            calculate();
            return;
        }

        for (int i = idx; i < ops.size(); i++) {
            list.add(i);
            dfs(i + 2);
            list.remove(list.size() - 1);
        }
    }


}
