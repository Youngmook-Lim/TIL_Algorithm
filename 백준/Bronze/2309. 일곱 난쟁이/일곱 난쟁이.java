import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Integer> dwarfs = new ArrayList<>();
    static int notDwarfsTotal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 9; i++) {
            dwarfs.add(Integer.parseInt(br.readLine()));
        }

        notDwarfsTotal = dwarfs.stream().mapToInt(x -> x).sum() - 100;

        find();

        for (int x : dwarfs) {
            if (x != 0) {
                bw.write(x + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void find() {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (dwarfs.get(i) + dwarfs.get(j) == notDwarfsTotal) {
                    dwarfs.set(i, 0);
                    dwarfs.set(j, 0);
                    Collections.sort(dwarfs);
                    return;
                }
            }
        }
    }


}

