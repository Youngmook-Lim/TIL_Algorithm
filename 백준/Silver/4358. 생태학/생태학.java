import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

    static String tree;
    static TreeMap<String, Double> trees;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        trees = new TreeMap<>();
        tree = br.readLine();
        while (true) {
            n++;
            trees.put(tree, trees.getOrDefault(tree, (double) 0) + 1);
            tree = br.readLine();
            if (tree == null || tree.length() == 0) break;
        }

        for (String t : trees.keySet()) {
            sb.append(t + " " + String.format("%.4f", trees.get(t) * 100 / n)).append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}

