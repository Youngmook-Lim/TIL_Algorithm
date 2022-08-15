import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static Map<Integer, List<Integer>> map;
    static int[] directions;
    static int[] distances;
    static List<Integer> longSides;
    static int big = 1;
    static int small;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        directions = new int[6];
        distances = new int[6];
        longSides = new ArrayList<>();

        k = Integer.parseInt(br.readLine());
//        map = new HashMap<>();
//
//        for (int i = 0; i < 6; i++) {
//            st = new StringTokenizer(br.readLine());
//            int direction = Integer.parseInt(st.nextToken());
//            int distance = Integer.parseInt(st.nextToken());
//            if (map.containsKey(direction)) {
//                map.get(direction).add(distance);
//            } else {
//                map.put(direction, new ArrayList<>());
//                map.get(direction).add(distance);
//            }
//        }

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            directions[i] = Integer.parseInt(st.nextToken());
            distances[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {
            int cnt = 1;
            for (int j = 0; j < 6; j++) {
                if (i == j) continue;
                if (directions[i] == directions[j]) {
                    cnt++;
                }
            }
            if (cnt == 1) {
                longSides.add(directions[i]);
            }
        }

        for (int x : longSides) {
            for (int i = 0; i < 6; i++) {
                if (directions[i] == x) {
                    big *= distances[i];
                    break;
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            if (longSides.contains(directions[i]) && !longSides.contains(directions[(i + 1) % 6])) {
                small = distances[(i + 2) % 6] * distances[(i + 3) % 6];
                break;
            }
        }

        bw.write((big - small) * k + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

}

