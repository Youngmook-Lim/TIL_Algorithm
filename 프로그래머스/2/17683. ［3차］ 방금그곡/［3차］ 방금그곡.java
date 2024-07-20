import java.util.*;

class Solution {
    
    class Music implements Comparable<Music> {
        int id;
        int len;
        String name;
        String score;
        
        Music(int id, int len, String name, String score) {
            this.id = id;
            this.len = len;
            this.name = name;
            this.score = score;
        }
        
        @Override
        public int compareTo(Music o) {
            if (this.len != o.len) {
                return o.len - this.len;
            }
            return this.id - o.id;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        
        // 1. Check for each music if it's a candidate -> put in PQ
        Queue<Music> pq = new PriorityQueue<>();
        int id = 0;
        
        for (String info : musicinfos) {
            String[] tmp = info.split(",");
            int len = getTime(tmp[0], tmp[1]);
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            for (int i = 0; i < len; i++) {
                char cur = tmp[3].charAt(idx % tmp[3].length());
                char next = tmp[3].charAt((idx + 1) % tmp[3].length());
                String note;
                if (next == '#') {
                    note = Character.toString(cur) + Character.toString(next);
                    idx += 2;
                } else {
                    note = Character.toString(cur);
                    idx++;
                }
                
                sb.append(note);
            }
            String score = sb.toString();

            if (doesMatch(score, m)) {
                pq.add(new Music(id++, len, tmp[2], score));
            }
        }
        
        // 2. Poll PQ
        Music answer = pq.poll();
        
        return answer == null ? "(None)" : answer.name;
    }
    
    public boolean doesMatch(String base, String snippet) {
        int b = base.length();
        int s = snippet.length();
        
        for (int i = 0; i < b - s + 1; i++) {
            boolean flag = false;
            for (int j = 0; j < s; j++) {
                if (snippet.charAt(j) != base.charAt(i + j)) {
                    flag = true;
                    break;
                } else {
                    if (j == s - 1 && i < b - s) {
                        if (base.charAt(i + j + 1) == '#') {
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if (!flag) {
                return true;
            }
        }
        return false;
    }
    
    public int getTime(String s, String e) {
        int sH = Integer.parseInt(s.split(":")[0]);
        int sM = Integer.parseInt(s.split(":")[1]);
        int eH = Integer.parseInt(e.split(":")[0]);
        int eM = Integer.parseInt(e.split(":")[1]);
        
        return (eH * 60 + eM) - (sH * 60 + sM);
    }
}