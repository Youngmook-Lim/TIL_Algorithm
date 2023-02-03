import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Word implements Comparable<Word> {
        String w;
        int len;
        int freq;

        public Word(String w, int len, int freq) {
            this.w = w;
            this.len = len;
            this.freq = freq;
        }

        @Override
        public int compareTo(Word o) {
            if (this.freq != o.freq) {
                return o.freq - this.freq;
            }
            if (this.len != o.len) {
                return o.len - this.len;
            }
            return this.w.compareTo(o.w);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<String, Integer> map = new HashMap<>();
        List<Word> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < m) continue;

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : map.keySet()) {
            int freq = map.get(word);
            int len = word.length();
            list.add(new Word(word, len, freq));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (Word w : list) {
            sb.append(w.w).append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}
