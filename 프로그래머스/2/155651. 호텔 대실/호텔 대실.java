import java.util.*;

class Solution {
    
    public class Time implements Comparable<Time> {
        int start, end;
        
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }   
        
        @Override
        public int compareTo(Time t) {
            if (this.end != t.end) {
                return t.end - this.end;
            }
            return t.start - this.start;
        }
        
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        List<Time> list = new ArrayList<>();
        List<Time> res = new ArrayList<>();
        
        for (String[] arr : book_time) {
            String start = arr[0];
            String end = arr[1];
            list.add(getNewTime(start, end));
        }
        
        Collections.sort(list);   
        
        for (Time t : list) {
            boolean flag = false;
            for (int i = 0; i < res.size(); i++) {
                Time r = res.get(i);
                if (t.end + 10 <= r.start) {
                    res.set(i, t);
                    flag = true;
                    break;
                }
            }
            
            if (!flag) {
                res.add(t);
            }
            
        }
        
        return res.size();
    }
    
    public Time getNewTime(String start, String end) {
        int startHour = Integer.parseInt(start.substring(0, 2));
        int startMin = Integer.parseInt(start.substring(3, 5));
        int endHour = Integer.parseInt(end.substring(0, 2));
        int endMin = Integer.parseInt(end.substring(3, 5));
        
        int startTotal = startHour * 60 + startMin;
        int endTotal = endHour * 60 + endMin;
        
        return new Time(startTotal, endTotal);
        
    }
}