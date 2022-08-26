import java.io.*;
import java.util.*;

public class Main {

    static class Person {
        int w, h, rank;

        public Person(int w, int h, int rank) {
            this.w = w;
            this.h = h;
            this.rank = rank;
        }
    }

    static int n;
    static Person[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new Person[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            Person p = new Person(w, h, -1);
            arr[i] = p;
        }

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[i].w < arr[j].w && arr[i].h < arr[j].h) {
                    cnt++;
                }
            }
            arr[i].rank = cnt;
        }

        for (Person p : arr) {
            bw.write(p.rank + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }


}