import java.util.*;

class Solution {
    
    class File implements Comparable<File> {
        String head, tail, numberStr, headStr;
        int number, idx;
        File(String head, String headStr, int number, String numberStr, String tail, int idx) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.idx = idx;
            this.numberStr = numberStr;
            this.headStr = headStr;
        }
        
        @Override
        public int compareTo(File o) {
            if (!o.head.equals(this.head)) {
                return this.head.compareTo(o.head);
            }
            if (this.number != o.number) {
                return this.number - o.number;
            }
            return this.idx - o.idx;
        } 
    }
    
    public String[] solution(String[] files) {
        
        List<File> list = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            String cur = files[i];
            int headEnd = -1;
            int numEnd = -1;
            
            for (int j = 0; j < cur.length(); j++) {
                char c = cur.toLowerCase().charAt(j);
                if (headEnd == -1) {
                    if ((c < 'a' || c > 'z') && c != '-' && c != '.' && c != ' ') {
                        headEnd = j--;
                    }
                } else if (numEnd == -1) {
                    if (c < '0' || c > '9') {
                        numEnd = j;
                        break;
                    }
                }
            }
            
            if (numEnd == -1) {
                numEnd = cur.length();
            }
 
            list.add(new File(cur.substring(0, headEnd).toLowerCase(), cur.substring(0, headEnd), Integer.parseInt(cur.substring(headEnd, numEnd)), cur.substring(headEnd,numEnd), cur.substring(numEnd), i));
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            File f = list.get(i);
            answer[i] = f.headStr + f.numberStr + f.tail;
        }
        
        return answer;
    }
}