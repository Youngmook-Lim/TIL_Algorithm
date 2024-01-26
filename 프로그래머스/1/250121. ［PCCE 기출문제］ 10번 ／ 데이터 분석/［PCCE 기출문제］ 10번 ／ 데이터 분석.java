import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    class Data {
        Integer code, date, maximum, remain;
        
        Data(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
    }
    
    List<Data> list, filteredList, sortedList;
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        list = new ArrayList<>();
        
        for (int[] d : data) {
            list.add(new Data(d[0], d[1], d[2], d[3]));
        }
        
        switch (ext) {
            case "code":
                filteredList = list.stream().filter(d -> d.code < val_ext).collect(Collectors.toList());
                break;
            case "date":
                filteredList = list.stream().filter(d -> d.date < val_ext).collect(Collectors.toList());
                break;
            case "maximum":
                filteredList = list.stream().filter(d -> d.maximum < val_ext).collect(Collectors.toList());
                break;
            case "remain":
                filteredList = list.stream().filter(d -> d.remain < val_ext).collect(Collectors.toList());
                break;
        }
        
        switch (sort_by) {
            case "code":
                sortedList = filteredList.stream().sorted((o1, o2) -> o1.code.compareTo(o2.code)).collect(Collectors.toList());
                break;
            case "date":
                sortedList = filteredList.stream().sorted((o1, o2) -> o1.date.compareTo(o2.date)).collect(Collectors.toList());
                break;
            case "maximum":
                sortedList = filteredList.stream().sorted((o1, o2) -> o1.maximum.compareTo(o2.maximum)).collect(Collectors.toList());
                break;
            case "remain":
                sortedList = filteredList.stream().sorted((o1, o2) -> o1.remain.compareTo(o2.remain)).collect(Collectors.toList());
                break;
        }
        
        int[][] answer = new int[sortedList.size()][4];
        
        for (int i = 0; i < sortedList.size(); i++) {
            answer[i][0] = sortedList.get(i).code;
            answer[i][1] = sortedList.get(i).date;
            answer[i][2] = sortedList.get(i).maximum;
            answer[i][3] = sortedList.get(i).remain;
        }
        
        return answer;
    }
}