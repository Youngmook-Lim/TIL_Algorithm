import java.io.*;
import java.util.*;

public class Main {

    static class Person {
        int w, h, idx, rank;

        public Person(int w, int h, int idx, int rank) {
            this.w = w;
            this.h = h;
            this.idx = idx;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "w=" + w +
                    ", h=" + h +
                    ", idx=" + idx +
                    ", rank=" + rank +
                    '}';
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
            Person p = new Person(w, h, i, -1);
            arr[i] = p;
        }

        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.w - o1.w;
            }
        });

        arr[0].rank = 1;

        for (int i = 1; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i].w < arr[j].w && arr[i].h < arr[j].h) {
                    cnt++;
                }
            }
            arr[i].rank = cnt;
        }

        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.idx - o2.idx;
            }
        });
        
        for (Person p : arr) {
            bw.write(p.rank + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }


}