import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, idx;
    static int[] inOrder, postOrder, preOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        preOrder = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        findPreOrder(0, n - 1, 0, n - 1);

        for (int x : preOrder) {
            System.out.print(x + " ");
        }

        br.close();
    }

    static void findPreOrder(int inStart, int inEnd, int postStart, int postEnd) {

        if (inStart > inEnd) return;

        preOrder[idx++] = postOrder[postEnd];

        int rootIdx = 0;
        for (int i = inStart; i < inEnd + 1; i++) {
            if (inOrder[i] == postOrder[postEnd]) {
                rootIdx = i;
                break;
            }
        }

        findPreOrder(inStart, rootIdx - 1, postStart, postStart + rootIdx - inStart - 1);
        findPreOrder(rootIdx + 1, inEnd, postStart + rootIdx - inStart, postEnd - 1);

    }


}
