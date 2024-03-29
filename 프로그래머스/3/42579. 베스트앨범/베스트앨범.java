import java.util.*;

class Solution {
    
    class Genre {
        String name;
        int total;
        Queue<P> q;
        Genre(String name) {
            this.name = name;
            this.total = 0;
            this.q = new PriorityQueue<>();
        }
    }
     
    class P implements Comparable<P>{
        int play, idx;
        P(int play, int idx) {
            this.play = play;
            this.idx = idx;
        }
        @Override
        public int compareTo(P o) {
            if (this.play != o.play) {
                return o.play - this.play;
            }
            return this.idx - o.idx;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Genre> map = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new Genre(genres[i]));
            }
            Genre g = map.get(genres[i]);
            g.total += plays[i];
            g.q.add(new P(plays[i], i));
        }
        
        List<Genre> genreList = new ArrayList<>();
        for (String x : map.keySet()) {
            genreList.add(map.get(x));
        }
        Collections.sort(genreList, (a, b) -> b.total - a.total);
        
        List<Integer> answer = new ArrayList<>();
        for (Genre g : genreList) {
            int cnt = 0;
            while (cnt++ < 2 && !g.q.isEmpty()) {
                answer.add(g.q.poll().idx);
            }
        }   
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}